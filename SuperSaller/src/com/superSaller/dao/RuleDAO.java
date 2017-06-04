package com.superSaller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.superSaller.beans.checkout.entities.DiscountRule;

@Repository(value = "ruleDAO")
public class RuleDAO extends BaseDAO<DiscountRule> {

	@Override
	public DiscountRule mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
