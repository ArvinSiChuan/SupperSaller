package com.superSaller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.superSaller.beans.checkout.entities.DiscountRule;

@Repository(value = "ruleDAO")
public class RuleDAO extends BaseDAO<DiscountRule> {
	public static final String ruleUUIDCol = "RULE_UUID";
	public static final String ruleTypeCol = "RULE_TYPE";
	public static final String emIDCol = "EM_ID";
	public static final String ruleNameCol = "RULE_NAME";
	public static final String discountRateCol = "DISCOUNT_RATE";
	public static final String freeMoneyCol = "FREE_MONEY";
	public static final String specialPriceCol = "SPECIAL_PRICE";
	public static final String conditionValueCol = "CONDITION_VALUE";
	public static final String datePeriodStartCol = "DATE_PERIOD_START";
	public static final String datePeriodEndCol = "DATE_PERIOD_END";
	public static final String dayPeriodStartCol = "DAY_PERIOD_START";
	public static final String dayPeriodEndCol = "DAY_PERIOD_END";
	private final String allFields = contactSqlFieds(ruleUUIDCol, ruleTypeCol, ruleNameCol, emIDCol, discountRateCol,
			freeMoneyCol, specialPriceCol, conditionValueCol, datePeriodStartCol, datePeriodEndCol, dayPeriodStartCol,
			dayPeriodEndCol);
	private final String insertIntoTable = "insert into discount_rules ";

	private final String formTable = " from discount_rules ";

	@Override
	public DiscountRule mapRow(ResultSet rs, int rowNum) throws SQLException {
		DiscountRule rule = new DiscountRule();
		rule.setUUID(rs.getString(ruleUUIDCol));
		rule.setName(rs.getString(ruleNameCol));
		rule.setType(rs.getString(ruleTypeCol));
		rule.setEmID(rs.getString(emIDCol));
		rule.setDiscountRate(rs.getDouble(discountRateCol));
		rule.setFreeMoney(rs.getDouble(freeMoneyCol));
		rule.setSpecialPrice(rs.getDouble(specialPriceCol));
		rule.setConditionValue(rs.getDouble(conditionValueCol));
		rule.setDatePeriodStart(rs.getTimestamp(datePeriodStartCol).toLocalDateTime());
		rule.setDatePeriodEnd(rs.getTimestamp(datePeriodEndCol).toLocalDateTime());
		rule.setDayPeriodStart(rs.getInt(dayPeriodStartCol));
		rule.setDayPeriodEnd(rs.getInt(dayPeriodEndCol));
		return rule;
	}

	public DiscountRule queryRuleByID(String uuid) {
		DiscountRule rule = null;
		String querySql = "select " + allFields + formTable + " where " + ruleUUIDCol + "=?";
		List<DiscountRule> list = getJdbcTemplate().query(querySql, this, uuid);
		if (list.size() > 0) {
			rule = list.get(0);
		}
		return rule;
	}

	public List<DiscountRule> queryRulesByEm(String emID) {
		String querySql = "select " + allFields + formTable + " where " + emIDCol + "=?";
		return getJdbcTemplate().query(querySql, this, emID);
	}

	public DiscountRule addRule(DiscountRule rule) {
		DiscountRule discountRule = null;
		String sql = insertIntoTable + "(" + allFields
				+ ") values (?,?,?,?,?,?,?,?,to_date(?,'yyyy-mm-dd hh24:mi:ss'),to_date(?,'yyyy-mm-dd hh24:mi:ss'),?,?) ";
		int r = getJdbcTemplate().update(sql, rule.getUUID(), rule.getType(), rule.getName(), rule.getEmID(),
				rule.getDiscountRate(), rule.getFreeMoney(), rule.getSpecialPrice(), rule.getConditionValue(),
				rule.getFormattedDateStart(), rule.getFormattedDateEnd(), rule.getDayPeriodStart(),
				rule.getDayPeriodEnd());
		if (r > 0) {
			discountRule = rule;
		}
		return discountRule;
	}

}
