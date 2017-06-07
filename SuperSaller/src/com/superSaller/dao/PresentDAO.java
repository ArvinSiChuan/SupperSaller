package com.superSaller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.superSaller.beans.checkout.entities.Present;

@Repository(value = "presentDAO")
public class PresentDAO extends BaseDAO<Present> {
	public static final String presentIDCol = "PRESENT_UUID";
	public static final String ruleIDCol = "RULE_UUID";
	public static final String presentTypeCol = "PRESENT_TYPE";
	public static final String conditionValueCol = "PRESENT_CONDITION_VALUE";
	public static final String discountValueCol = "PRESENT_DISCOUNT_VALUE";
	public static final String table = " PRESENTS ";
	public static final String fromTable = " from " + table;
	public static final String fromTableWhere = fromTable + " where ";
	public static final String insertIntoTable = "insert into " + table;
	private static final String allFields = contactSqlFieds(presentIDCol, presentTypeCol, conditionValueCol,
			discountValueCol, ruleIDCol);

	@Override
	public Present mapRow(ResultSet rs, int rowNum) throws SQLException {
		Present present = new Present();
		present.setPresentID(rs.getString(presentIDCol));
		present.setPresentType(rs.getString(presentTypeCol));
		present.setPresentConditionValue(rs.getString(conditionValueCol));
		present.setPresentDicountValue(rs.getString(discountValueCol));
		present.setRuleUUID(rs.getString(ruleIDCol));
		return present;
	}

	public Present getPresentByID(String presentID) {
		String querySql = "select " + fromTableWhere + presentIDCol + "=?";
		Present present = null;
		List<Present> list = getJdbcTemplate().query(querySql, this, presentID);
		if (list.size() > 0) {
			present = list.get(0);
		}
		return present;
	}

	public boolean addPresent(Present present) {
		String insertSql = insertIntoTable + allFields + " values(?,?,?,?,?)";
		int r = getJdbcTemplate().update(insertSql, present.getPresentID(), present.getPresentType(),
				present.getPresentConditionValue(), present.getPresentDicountValue(), present.getRuleUUID());
		return r == 1;
	}
}
