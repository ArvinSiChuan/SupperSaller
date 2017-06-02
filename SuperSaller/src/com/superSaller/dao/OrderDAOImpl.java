package com.superSaller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.superSaller.beans.checkout.entities.DiscountRule;
import com.superSaller.beans.checkout.entities.Order;
import com.superSaller.beans.outsideSupportSys.entities.Good;

@Repository(value = "orderDao")
public class OrderDAOImpl extends BaseDAO<Order> {

	public OrderDAOImpl() {
		super();
	}

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		// order.setOrderID(rs.getString(""));
		return order;
	}

	public Order createOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addGoodToOrder(Good good, Order order) {
		// TODO Auto-generated method stub

	}

	public void recordOrderRuleMatch(Order order, List<DiscountRule> rules) {
		// TODO Auto-generated method stub

	}

}
