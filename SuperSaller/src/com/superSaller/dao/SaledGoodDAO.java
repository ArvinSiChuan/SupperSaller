package com.superSaller.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.superSaller.beans.checkout.entities.SaledGood;
import com.superSaller.beans.checkout.entities.ViewSideGood;
import com.superSaller.beans.outsideSupportSys.GoodIO;

@Repository(value = "saledGoodDAO")
public class SaledGoodDAO extends BaseDAO<SaledGood> {
	private static final String goodIDCol = "GOOD_ID";
	private static final String saledDateCol = "SALED_DATE";
	private static final String sumCol = "SUM";
	private static final String priceCol = "PRICE ";
	private static final String orderIDCol = "ORDER_ID";
	private static final String fullCols = contactSqlFieds(goodIDCol, saledDateCol, sumCol, priceCol, orderIDCol);
	private final String oracleDateFomatter = "'yyyy-mm-dd hh24:mi:ss'";

	@Resource(name = "goodsSupport")
	private GoodIO goodDAO;

	@Resource(name = "saledGoodsRulesDAO")
	private SaledGoodsRulesDAO saledGoodsRulesDAO;

	@Override
	public SaledGood mapRow(ResultSet rs, int rowNum) throws SQLException {
		SaledGood good = new SaledGood();
		good.setGoodID(rs.getString(goodIDCol.trim()));
		good.setSaledDate(rs.getTimestamp(saledDateCol.trim()).toLocalDateTime());
		good.setSum(rs.getDouble(sumCol.trim()));
		good.setPrice(rs.getDouble(priceCol.trim()));
		good.setOrderID(rs.getString(orderIDCol.trim()));
		return good;
	}

	@Transactional
	public void addSaledGood(SaledGood good) {
		String querySql = "select count(*) as counter from saled_goods where " + goodIDCol + "=? and " + orderIDCol
				+ "=?";
		int records = getJdbcTemplate().query(querySql, new CounterRowMapper(), good.getGoodID(), good.getOrderID())
				.get(0);
		if (records > 0) {
			double sumValue = getJdbcTemplate()
					.query("select " + sumCol + "  from saled_goods where " + goodIDCol + "=? and " + orderIDCol + "=?",
							new RowMapper<Double>() {

								@Override
								public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
									return rs.getDouble(sumCol);
								}

							}, good.getGoodID(), good.getOrderID())
					.get(0);
			good.setSum(sumValue + good.getSum());
			updateSaledGood(good);
		} else {
			String sql = "insert into saled_goods (" + fullCols + ") values(?,to_date(?," + oracleDateFomatter
					+ "),?,?,?)";
			getJdbcTemplate().update(sql, good.getGoodID(), good.getFormatedSaledDate(), good.getSum(), good.getPrice(),
					good.getOrderID());
		}
	}

	@Transactional
	public SaledGood removeSaledGood(SaledGood good) {
		String sql = "delete from saled_goods where " + goodIDCol + "=? and " + orderIDCol + "=? ";
		int r = getJdbcTemplate().update(sql, good.getGoodID(), good.getOrderID());
		return good;
	}

	@Transactional
	public void updateSaledGood(SaledGood good) {
		String sql = "update saled_goods set " + goodIDCol + "=?," + saledDateCol + "=to_date(?," + oracleDateFomatter
				+ ")," + priceCol + "=?," + sumCol + "=?," + orderIDCol + "=? where " + goodIDCol + "=? and "
				+ orderIDCol + "=?";
		getJdbcTemplate().update(sql, good.getGoodID(), good.getFormatedSaledDate(), good.getPrice(), good.getSum(),
				good.getOrderID(), good.getGoodID(), good.getOrderID());
	}

	@Transactional
	public List<ViewSideGood> batchUpdateGoods(List<ViewSideGood> goods) {
		List<SaledGood> saledGoods = new ArrayList<SaledGood>();
		for (ViewSideGood viewSideGood : goods) {
			saledGoods.add(viewSideGood.getSaledGood());
		}
		String sql = "update saled_goods set " + goodIDCol + "=?," + saledDateCol + "=to_date(?," + oracleDateFomatter
				+ ")," + priceCol + "=?," + sumCol + "=?," + orderIDCol + "=? where " + goodIDCol + "=? and "
				+ orderIDCol + "=?";
		getJdbcTemplate().batchUpdate(sql, saledGoods, saledGoods.size(),
				new ParameterizedPreparedStatementSetter<SaledGood>() {

					@Override
					public void setValues(PreparedStatement ps, SaledGood saledGood) throws SQLException {
						ps.setString(1, saledGood.getGoodID());
						ps.setString(2, saledGood.getFormatedSaledDate());
						ps.setDouble(3, saledGood.getPrice());
						ps.setDouble(4, saledGood.getSum());
						ps.setString(5, saledGood.getOrderID());

						ps.setString(6, saledGood.getGoodID());
						ps.setString(7, saledGood.getOrderID());

					}

				});
		return getGoodsInsameOrder(goods.get(0));
	}

	public List<SaledGood> queryGoodsByOrderID(String orderID) {
		String sql = "select " + fullCols + " from saled_goods where order_id=?";
		List<SaledGood> saledGoods = getJdbcTemplate().query(sql, this, orderID);
		for (SaledGood saledGood : saledGoods) {
			saledGood.setRuleID(saledGoodsRulesDAO.getRulesByGood(saledGood));
		}
		return saledGoods;
	}

	public List<ViewSideGood> getGoodsInsameOrder(ViewSideGood good) {
		List<ViewSideGood> viewSideGoods = new ArrayList<ViewSideGood>();
		List<SaledGood> saledGoods = queryGoodsByOrderID(good.getOrderID());
		for (SaledGood saledGood : saledGoods) {
			ViewSideGood viewSideGood = ViewSideGood.getViewSideGoodFrom(goodDAO.getGood(saledGood.getGoodID()),
					saledGood);
			viewSideGoods.add(viewSideGood);
		}
		return viewSideGoods;
	}

}
