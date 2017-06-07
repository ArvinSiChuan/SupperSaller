package com.superSaller.beans.checkout.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.superSaller.beans.checkout.entities.DiscountRule;
import com.superSaller.beans.checkout.entities.ViewSideGood;

public class BUYFREEMatcher extends BasicGoodsMatcher {

	public List<ViewSideGood> match(DiscountRule rule, List<ViewSideGood> goods) {
		double totalMoney = 0, sum = 0, averageFreeMoney = 0, freeMoney = Double.MAX_VALUE;
		Map<String, Double> goodsNums = new TreeMap<String, Double>();
		for (ViewSideGood viewSideGood : goods) {
			sum += viewSideGood.getSum();
			totalMoney += viewSideGood.getSaledPrice() * viewSideGood.getSum();
			goodsNums.put(viewSideGood.getGoodID(), viewSideGood.getSum());
			freeMoney = viewSideGood.getSaledPrice() < freeMoney ? viewSideGood.getSaledPrice() : freeMoney;
		}

		if (rule.getBundleGoods().size() == 0) {
			if (sum >= rule.getConditionValue()) {
				freeMoney = rule.getFreeMoney() > 0 ? rule.getFreeMoney() : freeMoney;
				double discountMoney = (totalMoney - freeMoney) * (100 - rule.getDiscountRate()) / 100;
				averageFreeMoney = (discountMoney + freeMoney) / sum;
				for (ViewSideGood viewSideGood : goods) {
					viewSideGood.setSaledPrice(viewSideGood.getSaledPrice() - averageFreeMoney);
					List<String> list = viewSideGood.getRuleID();
					list.add(rule.getUUID());
				}
			}
		} else if (matchBundle(goodsNums, rule.getBundleGoods())) {

			Set<String> ids = rule.getBundleGoods().keySet();
			totalMoney = sum = averageFreeMoney = 0;
			freeMoney = Double.MAX_VALUE;
			int minMatchTimes = Integer.MAX_VALUE;
			List<ViewSideGood> bundleGoods = new ArrayList<ViewSideGood>();
			for (ViewSideGood viewSideGood : goods) {
				if (ids.contains(viewSideGood.getGoodID())) {
					bundleGoods.add(viewSideGood);
				}
			}
			for (ViewSideGood viewSideGood : bundleGoods) {
				sum += viewSideGood.getSum();
				totalMoney += viewSideGood.getSaledPrice() * viewSideGood.getSum();
				int min = (new Double(viewSideGood.getSum())).intValue();
				minMatchTimes = min < minMatchTimes ? min : minMatchTimes;
				freeMoney = viewSideGood.getSaledPrice() < freeMoney ? viewSideGood.getSaledPrice() : freeMoney;
			}
			int min = (new Double(rule.getConditionValue())).intValue();
			minMatchTimes = min < minMatchTimes ? min : minMatchTimes;

			System.out.println(freeMoney + "  " + minMatchTimes);
			freeMoney = freeMoney * minMatchTimes;

			double discountMoney = (totalMoney - freeMoney) * (100 - rule.getDiscountRate()) / 100;
			averageFreeMoney = (discountMoney + freeMoney) / sum;
			for (ViewSideGood viewSideGood : bundleGoods) {
				viewSideGood.setSaledPrice(viewSideGood.getSaledPrice() - averageFreeMoney);
				List<String> list = viewSideGood.getRuleID();
				list.add(rule.getUUID());
			}
		}
		return goods;
	}
}
