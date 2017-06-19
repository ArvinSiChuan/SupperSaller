package com.superSaller.beans.checkout.Impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superSaller.beans.checkout.DiscountMatcher;
import com.superSaller.beans.checkout.entities.DiscountRule;
import com.superSaller.beans.checkout.entities.Present;
import com.superSaller.beans.checkout.entities.ViewSideGood;
import com.superSaller.dao.RuleDAO;

/**
 * @author 邱依强
 * @version 1.0
 * @created 24-05-2017 8:44:40
 */
@Service(value = "ruleMatcher")
public class DiscountRuleMatcherImpl implements DiscountMatcher {
	private List<ViewSideGood> goods;
	private List<DiscountRule> rules;
	private List<Present> presents;

	@Resource(name = "ruleDAO")
	private RuleDAO ruleDAO;

	public DiscountRuleMatcherImpl() {
	}

	@Override
	public List<ViewSideGood> doDiscountRuleMatch(List<ViewSideGood> goods) {
		this.goods = goods;
		doRuleValidity();
		// rules = ruleDAO.queryAllRules(); // for test
		doRuleMatch();
		goods = this.goods;
		return goods;
	}

	private void doMutexCheck() {

	}

	public List<Present> getPresents() {
		return presents;
	}

	/**
	 * 
	 * @param customer
	 * @param rules
	 */
	private void doRuleMatch() {
		List<DiscountRule> partlyRules = new ArrayList<DiscountRule>();
		List<DiscountRule> globalRule = new ArrayList<DiscountRule>();
		for (DiscountRule rule : rules) {
			if (rule.getBundleGoods().size() == 0) {
				globalRule.add(rule);
			} else {
				partlyRules.add(rule);
			}
		}
		for (DiscountRule rule : partlyRules) {
			doDetailMatch(rule);
		}
		for (DiscountRule rule : globalRule) {
			doDetailMatch(rule);
		}
	}

	private void doDetailMatch(DiscountRule rule) {
		switch (rule.getType()) {
		case "FULLFREE":
			new FULLFREEMatcher().match(rule, goods);
			break;
		case "FULLCOUNT":
			new FULLCOUNTMatcher().match(rule, goods);
			break;
		case "FULLPRESENT":

			break;
		case "FULLVOUCHER":

			break;
		case "BUYPRESENT":

			break;
		case "BUYPRESET":

			break;
		case "BUYSPECIAL":

			break;
		case "BUYFREE":
			new BUYFREEMatcher().match(rule, goods);
			break;
		case "BUYCOUNT":

			break;
		case "BUYVOUCHER":

			break;

		}
	}

	// valid rules
	private void doRuleValidity() {
		List<DiscountRule> rules = ruleDAO.queryAllRules();
		List<DiscountRule> filteDiscountRules = new ArrayList<DiscountRule>();
		for (DiscountRule discountRule : rules) {
			boolean flag = true;
			LocalDateTime now = LocalDateTime.now();
			int miniteOfDayOfNow = now.getHour() * 60 + now.getMinute();
			if (discountRule.getDatePeriodStart().isAfter(LocalDateTime.now())) {
				// DATE NOT BEGIN
				flag = false;
			} else if (discountRule.getDatePeriodEnd().isBefore(LocalDateTime.now())) {
				// DATE ALREADY PASSED
				flag = false;
			} else if (discountRule.getDayPeriodStart() > miniteOfDayOfNow) {
				// TIME NOT BEGIN
				flag = false;
			} else if (discountRule.getDayPeriodEnd() < miniteOfDayOfNow) {
				// TIME ALREADY PASSED
				flag = false;
			}
			if (flag) {
				filteDiscountRules.add(discountRule);
			}
		}
		this.rules = filteDiscountRules;
	}

}