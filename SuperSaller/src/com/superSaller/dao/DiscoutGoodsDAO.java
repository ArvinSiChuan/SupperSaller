package com.superSaller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscoutGoodsDAO extends BaseDAO<Map<String, String>> {
	public static final String ruleUUIDCol = "RULE_UUID";
	public static final String goodIDCol = "GOOD_ID";
	public static final String numCol = "NUM";
	public static final String fromTable = " from DISCOUNT_GOODS ";
	public static final String insertIntoTable = "insert into DISCOUNT_GOODS ";

	@Override
	public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
		Map<String, String> map = new HashMap<String, String>();
		map.put(rs.getString(goodIDCol), rs.getString(numCol));
		return map;
	}

	public List<Map<String, String>> getGoodIDs(String ruleUUID) {
		String querySql = "select " + contactSqlFieds(goodIDCol, numCol) + fromTable + "where " + ruleUUID + "=?";
		return getJdbcTemplate().query(querySql, this, ruleUUID);
	}

	public void addGoodToRule(String ruleUUID, String goodID) {
		String insertSql = insertIntoTable + "(" + contactSqlFieds(ruleUUIDCol, goodIDCol, numCol) + ") values(?,?,?)";
		getJdbcTemplate().update(insertSql, ruleUUID, goodID);
	}
}
