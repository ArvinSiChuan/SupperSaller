package com.superSaller.beans.checkout;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import com.superSaller.beans.checkout.entities.DiscountRule;
import com.superSaller.beans.outsideSupportSys.entities.Good;

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
	public ArrayList<Map<DiscountRule, Good>> doDiscountRuleMatch(Set<Good> goods);
}