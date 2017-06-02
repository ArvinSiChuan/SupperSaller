package com.superSaller.beans.checkout.Impl;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.superSaller.beans.checkout.DiscountMatcher;
import com.superSaller.beans.checkout.entities.DiscountRule;
import com.superSaller.beans.checkout.entities.Present;
import com.superSaller.beans.outsideSupportSys.entities.Customer;
import com.superSaller.beans.outsideSupportSys.entities.Good;

/**
 * @author 邱依强
 * @version 1.0
 * @created 24-05-2017 8:44:40
 */
@Service(value = "ruleMatcher")
public class DiscountRuleMatcherImpl implements DiscountMatcher {

	private Customer customer;
	private Map<Good, Integer> goods;
	private Good goodSupport;
	private ArrayList<Map<DiscountRule, Good>> matchingRules;
	private DiscountRule relatedDiscountRule;

	public DiscountRuleMatcherImpl() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param goods
	 */
	public ArrayList<Map<DiscountRule, Good>> doDiscountRuleMatch(Set<Good> goods) {
		return null;
	}

	private ArrayList<Map<DiscountRule, Good>> doMutexCheck() {
		return null;
	}

	private int doPresentCheck() {
		return 0;
	}

	private Set<Present> doPresentDecision() {
		return null;
	}

	/**
	 * 
	 * @param customer
	 * @param rules
	 */
	private ArrayList<Map<DiscountRule, Good>> doRuleMatch(Customer customer, ArrayList<DiscountRule> rules) {
		return null;
	}

	private ArrayList<Map<DiscountRule, Good>> doValidity() {
		return null;
	}

	/**
	 * 
	 * @param customer
	 */
	private ArrayList<DiscountRule> filteCustomer(Customer customer) {
		return null;
	}

}