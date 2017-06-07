package com.superSaller.beans.checkout.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * @author 邱依强
 * @version 1.0
 * @created 24-05-2017 8:44:40
 */
public class DiscountRule {
	private String UUID;
	private String Type;
	private String Name;
	private String emID;
	private double discountRate;
	private double freeMoney;
	private double specialPrice;
	private double conditionValue;
	private Map<String, Double> bundleGoods;
	private List<Present> presents;
	private LocalDateTime datePeriodEnd;
	private LocalDateTime datePeriodStart;
	private int dayPeriodEnd = 1440;
	/**
	 * start at 00:00 counted by minutes
	 */
	private int dayPeriodStart = 0;
	private int priority = 0;
	private int weekPeriodEnd = 7;
	private int weekPeriodStart = 1;

	public DiscountRule() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uUID
	 * @param type
	 * @param name
	 * @param emID
	 * @param discountRate
	 * @param freeMoney
	 * @param specialPrice
	 * @param conditionValue
	 * @param bundleGoods
	 * @param datePeriodEnd
	 * @param datePeriodStart
	 * @param dayPeriodEnd
	 * @param dayPeriodStart
	 * @param priority
	 * @param weekPeriodEnd
	 * @param weekPeriodStart
	 */
	public DiscountRule(String UUID, String type, String name, String emID, double discountRate, double freeMoney,
			double specialPrice, double conditionValue, Map<String, Double> bundleGoods, LocalDateTime datePeriodEnd,
			LocalDateTime datePeriodStart, int dayPeriodEnd, int dayPeriodStart, int priority, int weekPeriodEnd,
			int weekPeriodStart) {
		super();
		this.UUID = UUID;
		Type = type;
		Name = name;
		this.emID = emID;
		this.discountRate = discountRate;
		this.freeMoney = freeMoney;
		this.specialPrice = specialPrice;
		this.conditionValue = conditionValue;
		this.bundleGoods = bundleGoods;
		this.datePeriodEnd = datePeriodEnd;
		this.datePeriodStart = datePeriodStart;
		this.dayPeriodEnd = dayPeriodEnd;
		this.dayPeriodStart = dayPeriodStart;
		this.priority = priority;
		this.weekPeriodEnd = weekPeriodEnd;
		this.weekPeriodStart = weekPeriodStart;
	}

	private DateTimeFormatter getFomatter() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	}

	public String getFormattedDateStart() {
		return datePeriodStart.format(getFomatter());
	}

	public String getFormattedDateEnd() {
		return datePeriodEnd.format(getFomatter());
	}

	/**
	 * @return the uUID
	 */
	public String getUUID() {
		return UUID;
	}

	/**
	 * @param uUID
	 *            the uUID to set
	 */
	public void setUUID(String uUID) {
		UUID = uUID;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return Type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		Type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the emID
	 */
	public String getEmID() {
		return emID;
	}

	/**
	 * @param emID
	 *            the emID to set
	 */
	public void setEmID(String emID) {
		this.emID = emID;
	}

	/**
	 * @return the discountRate
	 */
	public double getDiscountRate() {
		return discountRate;
	}

	/**
	 * @param discountRate
	 *            the discountRate to set
	 */
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	/**
	 * @return the freeMoney
	 */
	public double getFreeMoney() {
		return freeMoney;
	}

	/**
	 * @param freeMoney
	 *            the freeMoney to set
	 */
	public void setFreeMoney(double freeMoney) {
		this.freeMoney = freeMoney;
	}

	/**
	 * @return the specialPrice
	 */
	public double getSpecialPrice() {
		return specialPrice;
	}

	/**
	 * @param specialPrice
	 *            the specialPrice to set
	 */
	public void setSpecialPrice(double specialPrice) {
		this.specialPrice = specialPrice;
	}

	/**
	 * @return the conditionValue
	 */
	public double getConditionValue() {
		return conditionValue;
	}

	/**
	 * @param conditionValue
	 *            the conditionValue to set
	 */
	public void setConditionValue(double conditionValue) {
		this.conditionValue = conditionValue;
	}

	/**
	 * @return the bundleGoods
	 */
	public Map<String, Double> getBundleGoods() {
		return bundleGoods;
	}

	/**
	 * @param bundleGoods
	 *            the bundleGoods to set
	 */
	public void setBundleGoods(Map<String, Double> bundleGoods) {
		this.bundleGoods = bundleGoods;
	}

	/**
	 * @return the datePeriodEnd
	 */
	public LocalDateTime getDatePeriodEnd() {
		return datePeriodEnd;
	}

	/**
	 * @param datePeriodEnd
	 *            the datePeriodEnd to set
	 */
	public void setDatePeriodEnd(LocalDateTime datePeriodEnd) {
		this.datePeriodEnd = datePeriodEnd;
	}

	/**
	 * @return the datePeriodStart
	 */
	public LocalDateTime getDatePeriodStart() {
		return datePeriodStart;
	}

	/**
	 * @param datePeriodStart
	 *            the datePeriodStart to set
	 */
	public void setDatePeriodStart(LocalDateTime datePeriodStart) {
		this.datePeriodStart = datePeriodStart;
	}

	/**
	 * @return the dayPeriodEnd
	 */
	public int getDayPeriodEnd() {
		return dayPeriodEnd;
	}

	/**
	 * @param dayPeriodEnd
	 *            the dayPeriodEnd to set
	 */
	public void setDayPeriodEnd(int dayPeriodEnd) {
		this.dayPeriodEnd = dayPeriodEnd;
	}

	/**
	 * @return the dayPeriodStart
	 */
	public int getDayPeriodStart() {
		return dayPeriodStart;
	}

	/**
	 * @param dayPeriodStart
	 *            the dayPeriodStart to set
	 */
	public void setDayPeriodStart(int dayPeriodStart) {
		this.dayPeriodStart = dayPeriodStart;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return the weekPeriodEnd
	 */
	public int getWeekPeriodEnd() {
		return weekPeriodEnd;
	}

	/**
	 * @param weekPeriodEnd
	 *            the weekPeriodEnd to set
	 */
	public void setWeekPeriodEnd(int weekPeriodEnd) {
		this.weekPeriodEnd = weekPeriodEnd;
	}

	/**
	 * @return the weekPeriodStart
	 */
	public int getWeekPeriodStart() {
		return weekPeriodStart;
	}

	/**
	 * @param weekPeriodStart
	 *            the weekPeriodStart to set
	 */
	public void setWeekPeriodStart(int weekPeriodStart) {
		this.weekPeriodStart = weekPeriodStart;
	}

}