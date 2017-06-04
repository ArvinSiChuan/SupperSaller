package com.superSaller.beans.checkout.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superSaller.beans.checkout.OrderProcess;
import com.superSaller.beans.checkout.entities.ViewSideGood;
import com.superSaller.beans.payment.PaymentProcess;
import com.superSaller.dao.OrderDAO;
import com.superSaller.dao.SaledGoodDAO;

/**
 * @author 邱依强
 * @version 1.0
 * @created 24-05-2017 8:44:41
 */
@Service("orderProcess")
public class OrderProcessImpl implements OrderProcess {
	@Resource(name = "orderDAO")
	private OrderDAO orderDAO;

	@Resource(name = "saledGoodDAO")
	private SaledGoodDAO saledGoodDAO;

	private PaymentProcess paymentProcess;

	@Override
	public String createOrder() {
		return orderDAO.createOrder();
	}

	@Override
	public List<ViewSideGood> addGoodAndMatch(ViewSideGood good) {
		List<ViewSideGood> viewSideGoods = addGood(good);
		return viewSideGoods;
	}

	@Override
	public List<ViewSideGood> removeGoodAndMatch(ViewSideGood good) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<ViewSideGood> addGood(ViewSideGood good) {
		if (orderDAO.queryOrder(good.getOrderID()) == null) {
			good.setOrderID(createOrder());
		}
		saledGoodDAO.addSaledGood(good.getSaledGood());
		return saledGoodDAO.getGoodsInsameOrder(good);
	}

	@Override
	public void finishOrder() {
		// TODO Auto-generated method stub

	}

}