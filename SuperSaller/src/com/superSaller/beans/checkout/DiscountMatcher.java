package com.superSaller.beans.checkout;

import java.util.List;

import com.superSaller.beans.checkout.entities.ViewSideGood;

/**
 * @author 邱依强
 * @version 1.0
 * @created 24-5-2017 8:44:40
 */
public interface DiscountMatcher {

	/**
	 * 
	 * @param goods
	 */
	public List<ViewSideGood> doDiscountRuleMatch(List<ViewSideGood> goods);
}