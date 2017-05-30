package com.supperSaller.beans.checkout.Impl;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import com.supperSaller.beans.checkout.DiscountMatcher;
import com.supperSaller.beans.checkout.entities.DiscountRule;
import com.supperSaller.beans.checkout.entities.Present;
import com.supperSaller.beans.outsideSupportSys.entities.Customer;
import com.supperSaller.beans.outsideSupportSys.entities.Good;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:40
 */
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