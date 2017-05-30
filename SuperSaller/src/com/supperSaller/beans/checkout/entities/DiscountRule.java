package com.supperSaller.beans.checkout.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

import com.supperSaller.beans.outsideSupportSys.entities.Good;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:40
 */
public class DiscountRule {

	private Set<ArrayList<Good>> bundleGoods = null;
	private LocalDateTime datePeriodEnd = null;
	private LocalDateTime datePeriodStart = null;
	private int dayPeriodEnd = 1440;
	/**
	 * start at 00:00 counted by minutes
	 */
	private int dayPeriodStart = 0;
	private int priority = 0;
	private int singleGoods = 0;
	private int weekPeriodEnd = 7;
	private int weekPeriodStart = 1;

}