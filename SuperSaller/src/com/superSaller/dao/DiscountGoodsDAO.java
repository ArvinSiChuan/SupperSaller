package com.superSaller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

@Repository(value = "discountGoodsDAO")
public class DiscountGoodsDAO extends BaseDAO<Map<String, Double>> {
	public static final String ruleUUIDCol = "RULE_UUID";
	public static final String goodIDCol = "GOOD_ID";
	public static final String numCol = "NUM";
	public static final String table = "DISCOUNT_GOODS";
	public static final String fromTable = " from  " + table;
	public static final String insertIntoTable = "insert into " + table;

	@Override
	public Map<String, Double> mapRow(ResultSet rs, int rowNum) throws SQLException {
		Map<String, Double> map = new HashMap<String, Double>();
		map.put(rs.getString(goodIDCol), rs.getDouble(numCol));
		return map;
	}

	public Map<String, Double> getGoods(String ruleUUID) {
		String querySql = "select " + contactSqlFieds(goodIDCol, numCol) + fromTable + " where " + ruleUUIDCol + "=?";
		List<Map<String, Double>> list = getJdbcTemplate().query(querySql, this, ruleUUID);
		Map<String, Double> goods = new TreeMap<String, Double>();
		for (Map<String, Double> map : list) {
			goods.putAll(map);
		}
		return goods;
	}

	public boolean addGoodToRule(String ruleUUID, String goodID, double num) {
		String insertSql = insertIntoTable + "(" + contactSqlFieds(ruleUUIDCol, goodIDCol, numCol) + ") values(?,?,?)";
		int r = getJdbcTemplate().update(insertSql, ruleUUID, goodID, num);
		return r == 1;
	}

	public boolean removeGoodFromRule(String ruleUUID, String goodID) {
		String deleteSql = "delete " + fromTable + " where " + ruleUUIDCol + " =? and " + goodIDCol + " =?";
		int r = getJdbcTemplate().update(deleteSql, ruleUUID, goodID);
		return r == 1;
	}

	public boolean updateNumOfGood(String ruleUUID, String goodID, double num) {
		String updateSql = "update " + table + " set " + numCol + "=? where " + ruleUUIDCol + " =? and " + goodIDCol
				+ " =?";
		int r = getJdbcTemplate().update(updateSql, num, ruleUUID, goodID);
		return r == 1;
	}
}
