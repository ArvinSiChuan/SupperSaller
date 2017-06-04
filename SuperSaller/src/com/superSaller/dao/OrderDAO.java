package com.superSaller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.superSaller.beans.checkout.entities.DiscountRule;
import com.superSaller.beans.checkout.entities.Order;

@Repository(value = "orderDAO")
public class OrderDAO extends BaseDAO<Order> {
	private final String orderIDCol = "ORDER_ID";
	private final String orderSumCol = "ORDER_SUM";
	private final String sumMoneyCol = "SUM_MONEY";
	private final String orderCusIDCol = "ORDER_CUS_ID";
	private final String orderStatusCol = "ORDER_STATUS";
	private final String paymentIDCol = "PAYMENT_ID";
	private final String emIDCol = "EM_ID";
	private String userName;

	@Resource(name = "cashSideEmDAO")
	private CashSideEmployeeDAO emDao;

	@Resource(name = "saledGoodDAO")
	private SaledGoodDAO saledGoodDAO;

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setOrderID(rs.getString(orderIDCol));
		order.setOrderSum(rs.getInt(orderSumCol));
		order.setSumMoney(rs.getDouble(sumMoneyCol));
		order.setEmployee(emDao.queryEmployeeByID(rs.getString(emIDCol)));
		order.setStatus(rs.getString(orderStatusCol));

		// TODO
		order.setRelatedDiscountRules(null);
		order.setGoodsList(null);
		order.setRelatedPayment(null);
		order.setRelatedCustomer(null);
		return order;
	}

	@Transactional
	public String createOrder() {
		String id = null;
		UUID uuid = UUID.randomUUID();
		String sql = "INSERT INTO ORDERS (SUM_MONEY,ORDER_SUM,ORDER_STATUS,EM_ID) values (?,?,?,?)";
		String getIDSql = "select order_id from orders where order_status=?";
		getJdbcTemplate().update(sql, 0.0, 0.0, uuid.toString(), getUserName());
		List<String> list = getJdbcTemplate().query(getIDSql, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("order_id");
			}
		}, uuid.toString());
		for (String string : list) {
			id = string;
		}
		getJdbcTemplate().update("update orders set order_status=? where order_id=?", "inited", id);
		return id;

	}

	public List<Order> fuzzyQueryOrders(String id) {
		String sql = "select " + contactSqlFieds(orderIDCol, orderSumCol, orderCusIDCol, orderStatusCol, sumMoneyCol,
				paymentIDCol, emIDCol) + " from orders " + "where " + orderIDCol + " like ?";
		return getJdbcTemplate().query(sql, this, "%" + id + "%");
	}

	public Order queryOrder(String id) {
		Order order = null;
		String sql = "select " + contactSqlFieds(orderIDCol, orderSumCol, orderCusIDCol, orderStatusCol, sumMoneyCol,
				paymentIDCol, emIDCol) + " from orders " + "where " + orderIDCol + " =  ?";
		List<Order> orders = getJdbcTemplate().query(sql, this, id);
		if (orders.size() > 0) {
			order = orders.get(0);
		}
		return order;
	}

	public void recordOrderRuleMatch(Order order, List<DiscountRule> rules) {
		// TODO Auto-generated method stub

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

	private String getUserName() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (userName == null) {
			userName = userDetails.getUsername();
			userDetails.isAccountNonExpired();
		}
		return userName;
	}
}
