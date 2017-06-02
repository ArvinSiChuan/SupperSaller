package com.superSaller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.superSaller.beans.checkout.entities.DiscountRule;

@Repository("ruleDAO")
public class DiscountRuleDAOImpl extends BaseDAO<DiscountRule> {

	@Override
	public DiscountRule mapRow(ResultSet rs, int rowNum) throws SQLException {

		return null;
	}

	public ArrayList<DiscountRule> queryRulesByDate(LocalDateTime startDate, LocalDateTime endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public DiscountRule queryRulesByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
