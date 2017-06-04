package com.superSaller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.superSaller.beans.checkout.entities.SaledGood;
import com.superSaller.beans.checkout.entities.ViewSideGood;
import com.superSaller.beans.outsideSupportSys.GoodIO;

@Repository(value = "saledGoodDAO")
public class SaledGoodDAO extends BaseDAO<SaledGood> {
	private final String goodIDCol = "GOOD_ID";
	private final String saledDateCol = "SALED_DATE";
	private final String sumCol = "SUM";
	private final String priceCol = "PRICE";
	private final String orderIDCol = "ORDER_ID";
	private final String fullCols = contactSqlFieds(goodIDCol, saledDateCol, sumCol, priceCol, orderIDCol);
	private final String oracleDateFomatter = "'yyyy-mm-dd hh24:mi:ss'";

	@Resource(name = "goodsSupport")
	private GoodIO goodDAO;

	@Override
	public SaledGood mapRow(ResultSet rs, int rowNum) throws SQLException {
		SaledGood good = new SaledGood();
		good.setGoodID(rs.getString(goodIDCol));
		good.setSaledDate(rs.getTimestamp(saledDateCol).toLocalDateTime());
		good.setSum(rs.getDouble(sumCol));
		good.setPrice(rs.getDouble(priceCol));
		good.setOrderID(rs.getString(orderIDCol));
		return good;
	}

	@Transactional
	public void addSaledGood(SaledGood good) {
		String querySql = "select count(*) as counter from saled_goods where good_id=? and order_id=?";
		int records = getJdbcTemplate().query(querySql, new CounterRowMapper(), good.getGoodID(), good.getOrderID())
				.get(0);
		if (records > 0) {
			double sumValue = getJdbcTemplate().query(
					"select " + sumCol + "  from saled_goods where good_id=? and order_id=?", new RowMapper<Double>() {

						@Override
						public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
							return rs.getDouble(sumCol);
						}

					}, good.getGoodID(), good.getOrderID()).get(0);
			good.setSum(sumValue + good.getSum());
			updateSaledGood(good);
		} else {
			String sql = "insert into saled_goods (" + fullCols + ") values(?,to_date(?," + oracleDateFomatter
					+ "),?,?,?)";
			getJdbcTemplate().update(sql, good.getGoodID(), good.getFormatedSaledDate(), good.getSum(), good.getPrice(),
					good.getOrderID());
		}
	}

	public void removeSaledGood(SaledGood good) {
		String sql = "delete from saled_goods where good_id=? and saled_date=? ";
		getJdbcTemplate().update(sql, good.getGoodID(), good.getSaledDate());

	}

	public void updateSaledGood(SaledGood good) {
		String sql = "update saled_goods set " + goodIDCol + "=?," + saledDateCol + "=to_date(?," + oracleDateFomatter
				+ ")," + priceCol + "=?," + sumCol + "=?," + orderIDCol + "=? where " + goodIDCol + "=? and "
				+ orderIDCol + "=?";
		getJdbcTemplate().update(sql, good.getGoodID(), good.getFormatedSaledDate(), good.getPrice(), good.getSum(),
				good.getOrderID(), good.getGoodID(), good.getOrderID());
	}

	public List<SaledGood> queryGoodsByOrderID(String orderID) {
		String sql = "select " + fullCols + " from saled_goods where order_id=?";
		return getJdbcTemplate().query(sql, this, orderID);
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

	private String contactSqlFieds(String... fileds) {
		String contacted = " ";
		for (int i = 0; i < fileds.length; i++) {
			if (i == (fileds.length - 1)) {
				contacted += fileds[i] + " ";
			} else {
				contacted += fileds[i] + ",";
			}
		}
		return contacted;
	}

}
