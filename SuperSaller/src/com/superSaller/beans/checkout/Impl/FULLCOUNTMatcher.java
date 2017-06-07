package com.superSaller.beans.checkout.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.superSaller.beans.checkout.entities.DiscountRule;
import com.superSaller.beans.checkout.entities.ViewSideGood;

public class FULLCOUNTMatcher extends BasicGoodsMatcher {

	public List<ViewSideGood> match(DiscountRule rule, List<ViewSideGood> goods) {
		double totalMoney = 0, sum = 0, averageFreeMoney;
		Map<String, Double> goodsNums = new TreeMap<String, Double>();
		for (ViewSideGood viewSideGood : goods) {
			sum += viewSideGood.getSum();
			totalMoney += viewSideGood.getSaledPrice() * viewSideGood.getSum();
			goodsNums.put(viewSideGood.getGoodID(), viewSideGood.getSum());
		}
		if (rule.getBundleGoods().size() == 0) {
			if (totalMoney >= rule.getConditionValue()) {
				double discountMoney = totalMoney * (100 - rule.getDiscountRate()) / 100;
				averageFreeMoney = discountMoney / sum;
				for (ViewSideGood viewSideGood : goods) {
					viewSideGood.setSaledPrice(viewSideGood.getSaledPrice() - averageFreeMoney);
					List<String> list = viewSideGood.getRuleID();
					list.add(rule.getUUID());
				}
			}
		} else if (matchBundle(goodsNums, rule.getBundleGoods())) {
			Set<String> ids = rule.getBundleGoods().keySet();
			totalMoney = sum = averageFreeMoney = 0;
			List<ViewSideGood> bundleGoods = new ArrayList<ViewSideGood>();
			for (ViewSideGood viewSideGood : goods) {
				if (ids.contains(viewSideGood.getGoodID())) {
					bundleGoods.add(viewSideGood);
				}
			}
			for (ViewSideGood viewSideGood : bundleGoods) {
				sum += viewSideGood.getSum();
				totalMoney += viewSideGood.getSaledPrice() * viewSideGood.getSum();
			}
			double discountMoney = totalMoney * (100 - rule.getDiscountRate()) / 100;
			averageFreeMoney = discountMoney / sum;
			for (ViewSideGood viewSideGood : bundleGoods) {
				viewSideGood.setSaledPrice(viewSideGood.getSaledPrice() - averageFreeMoney);
				List<String> list = viewSideGood.getRuleID();
				list.add(rule.getUUID());
			}
		}
		return goods;
	}
}
