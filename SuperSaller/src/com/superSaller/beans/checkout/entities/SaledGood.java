package com.superSaller.beans.checkout.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SaledGood {
	private String goodID;
	private LocalDateTime saledDate;
	private double sum;
	private double price;
	private String orderID;
	private List<String> RuleID;

	public SaledGood() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param goodID
	 * @param saled_date
	 * @param sum
	 * @param price
	 * @param orderID
	 */
	public SaledGood(String goodID, LocalDateTime saledDate, int sum, double price, String orderID) {
		super();
		this.goodID = goodID;
		this.saledDate = saledDate;
		this.sum = sum;
		this.price = price;
		this.orderID = orderID;
	}

	/**
	 * @return the groupID
	 */
	public List<String> getRuleID() {
		return RuleID;
	}

	/**
	 * @param groupID
	 *            the groupID to set
	 */
	public void setRuleID(List<String> ruleID) {
		this.RuleID = ruleID;
	}

	/**
	 * @param saledDate
	 *            the saledDate to set
	 */
	public void setSaledDate(LocalDateTime saledDate) {
		this.saledDate = saledDate;
	}

	/**
	 * @return the goodID
	 */
	public String getGoodID() {
		return goodID;
	}

	/**
	 * @param goodID
	 *            the goodID to set
	 */
	public void setGoodID(String goodID) {
		this.goodID = goodID;
	}

	/**
	 * @return the saled_date
	 */
	public LocalDateTime getSaledDate() {
		return saledDate;
	}

	/**
	 * @return the sum
	 */
	public double getSum() {
		return sum;
	}

	/**
	 * @param sum
	 *            the sum to set
	 */
	public void setSum(double sum) {
		this.sum = sum;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the orderID
	 */
	public String getOrderID() {
		return orderID;
	}

	/**
	 * @param orderID
	 *            the orderID to set
	 */
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String toRowString() {
		return goodID + "," + saledDate + "," + sum + "," + price + "," + orderID;
	}

	public String getFormatedSaledDate() {
		return saledDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
}
