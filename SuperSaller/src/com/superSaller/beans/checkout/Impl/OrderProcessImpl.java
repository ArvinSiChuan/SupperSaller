package com.superSaller.beans.checkout.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superSaller.beans.checkout.DiscountMatcher;
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

	@Resource(name = "ruleMatcher")
	private DiscountMatcher matcher;

	private PaymentProcess paymentProcess;

	@Override
	public String createOrder() {
		return orderDAO.createOrder();
	}

	@Override
	public List<ViewSideGood> addGoodAndMatch(ViewSideGood good) {
		List<ViewSideGood> viewSideGoods = addGood(good);
		resetSaledPrice(viewSideGoods);
		matcher.doDiscountRuleMatch(viewSideGoods);
		// return viewSideGoods;
		return batchUpdateGood(viewSideGoods);
	}

	@Override
	public List<ViewSideGood> removeGoodAndMatch(ViewSideGood good) {
		List<ViewSideGood> viewSideGoods = removeGood(good);
		if (viewSideGoods.size() > 0) {
			resetSaledPrice(viewSideGoods);
			matcher.doDiscountRuleMatch(viewSideGoods);
			// return viewSideGoods;
			return batchUpdateGood(viewSideGoods);
		} else {
			return new ArrayList<ViewSideGood>();
		}

	}

	private List<ViewSideGood> addGood(ViewSideGood good) {
		if (orderDAO.queryOrder(good.getOrderID()) == null) {
			good.setOrderID(createOrder());
		}
		saledGoodDAO.addSaledGood(good.getSaledGood());
		return saledGoodDAO.getGoodsInsameOrder(good);
	}

	private List<ViewSideGood> removeGood(ViewSideGood good) {
		saledGoodDAO.removeSaledGood(good.getSaledGood());
		return saledGoodDAO.getGoodsInsameOrder(good);
	}

	private void resetSaledPrice(List<ViewSideGood> goods) {
		for (ViewSideGood viewSideGood : goods) {
			viewSideGood.setSaledPrice(viewSideGood.getGoodPrice());
		}
	}

	private List<ViewSideGood> batchUpdateGood(List<ViewSideGood> goods) {
		// not set rule that matched
		return saledGoodDAO.batchUpdateGoods(goods);
	}

	@Override
	public List<ViewSideGood> getAddedGoodsByOrder(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void finishOrder() {
		// TODO Auto-generated method stub

	}

}