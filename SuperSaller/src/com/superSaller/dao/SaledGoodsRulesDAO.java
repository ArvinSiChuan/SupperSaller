package com.superSaller.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.superSaller.beans.checkout.entities.SaledGood;

@Repository(value = "saledGoodsRulesDAO")
public class SaledGoodsRulesDAO extends BaseDAO<Map<String, String>> {
	public static final String goodIDCol = " GOOD_ID ";
	public static final String orderIDCol = " ORDER_ID ";
	public static final String ruleUUIDCol = " RULE_UUID ";
	public static final String allFields = contactSqlFieds(goodIDCol, orderIDCol, ruleUUIDCol);
	public static final String table = " rules_saled_goods ";
	private static final String fromTable = " from " + table;
	private static final String insertIntoTable = " insert into" + table;

	@Override
	public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
		Map<String, String> goodIDMap = new HashMap<String, String>();
		Map<String, String> orderIDMap = new HashMap<String, String>();
		Map<String, String> ruleUUIDMap = new HashMap<String, String>();
		orderIDMap.put(orderIDCol, rs.getString(orderIDCol));
		goodIDMap.put(goodIDCol, rs.getString(goodIDCol));
		ruleUUIDMap.put(ruleUUIDCol, rs.getString(ruleUUIDCol));
		return goodIDMap;
	}

	public List<String> getGoodIDsByOrder(String orderID) {
		String querySql = "select " + goodIDCol + fromTable + "where " + orderIDCol + "=?";
		return getJdbcTemplate().query(querySql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(goodIDCol);
			}

		}, orderID);
	}

	public List<String> getRulesByGood(SaledGood good) {
		String querySql = "select " + ruleUUIDCol + fromTable + "where " + goodIDCol + "=? and" + orderIDCol + "=?";
		List<String> list = getJdbcTemplate().query(querySql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(ruleUUIDCol);
			}

		}, good.getGoodID(), good.getOrderID());
		return list;
	}

	@Transactional
	public void saveRulesByGood(SaledGood good, List<String> rules) {
		String querySql = "select count(*)" + fromTable + "where " + goodIDCol + "=? and" + orderIDCol + "=?";
		int record = getJdbcTemplate().queryForList(querySql, Integer.class, good.getGoodID(), good.getOrderID())
				.get(0);
		if (record == 0) {
			String insertSql = insertIntoTable + "(" + allFields + ") values (?,?,?)";
			getJdbcTemplate().batchUpdate(insertSql, rules, rules.size(),
					new ParameterizedPreparedStatementSetter<String>() {

						@Override
						public void setValues(PreparedStatement ps, String ruleID) throws SQLException {
							ps.setString(1, good.getGoodID());
							ps.setString(2, good.getOrderID());
							ps.setString(3, ruleID);
						}
					});
		} else {
			String updateSql = "update " + table + " set " + ruleUUIDCol + "=?  where " + goodIDCol + "=? and "
					+ orderIDCol + "=?";
			getJdbcTemplate().batchUpdate(updateSql, rules, rules.size(),
					new ParameterizedPreparedStatementSetter<String>() {

						@Override
						public void setValues(PreparedStatement ps, String ruleID) throws SQLException {
							ps.setString(1, ruleID);
							ps.setString(2, good.getGoodID());
							ps.setString(3, good.getOrderID());

						}
					});
		}
	}

}
