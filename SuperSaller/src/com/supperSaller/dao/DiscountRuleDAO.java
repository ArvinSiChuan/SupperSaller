package com.supperSaller.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.supperSaller.beans.checkout.entities.DiscountRule;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:40
 */
public interface DiscountRuleDAO {

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 */
	public ArrayList<DiscountRule> queryRulesByDate(LocalDateTime startDate, LocalDateTime endDate);

	/**
	 * 
	 * @param ID
	 */
	public DiscountRule queryRulesByID(String ID);

}