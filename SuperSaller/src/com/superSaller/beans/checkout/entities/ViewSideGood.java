package com.superSaller.beans.checkout.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;

import com.superSaller.beans.outsideSupportSys.entities.Good;

@Entity
public class ViewSideGood extends Good {
	private SaledGood saledGood;

	public ViewSideGood() {
		super();
		saledGood = new SaledGood();
	}

	public ViewSideGood(String goodID, String goodName, String goodSpecifications, double goodPrice, String goodType,
			String goodBrand, String goodProducer, String goodDesc, LocalDateTime saledDate, double saledPrice, int sum,
			String orderID) {
		super(goodID, goodName, goodSpecifications, goodPrice, goodType, goodBrand, goodProducer, goodDesc);
		saledGood = new SaledGood(goodID, saledDate, sum, saledPrice, orderID);
	}

	public static ViewSideGood getViewSideGoodFrom(Good good, SaledGood saledGood) {
		ViewSideGood viewSideGood = new ViewSideGood();
		viewSideGood.setGoodID(good.getGoodID());
		viewSideGood.setGoodBrand(good.getGoodBrand());
		viewSideGood.setGoodDesc(good.getGoodDesc());
		viewSideGood.setGoodName(good.getGoodName());
		viewSideGood.setGoodPrice(good.getGoodPrice());
		viewSideGood.setGoodProducer(good.getGoodProducer());
		viewSideGood.setGoodSpecifications(good.getGoodSpecifications());
		viewSideGood.setGoodType(good.getGoodType());
		if (viewSideGood.setSaledGood(saledGood)) {
			return viewSideGood;
		}
		return viewSideGood;

	}

	/**
	 * @return the saledGood
	 */
	public SaledGood getSaledGood() {
		syncGood();
		return saledGood;
	}

	/**
	 * @param saledGood
	 *            the saledGood to set
	 */
	public boolean setSaledGood(SaledGood saledGood) {
		boolean flag = false;
		if (getGoodID() == null || saledGood == null || saledGood.getGoodID() == null) {
			flag = false;
		} else if (saledGood.getGoodID().equals(getGoodID())) {
			this.saledGood = saledGood;
			flag = true;
		}
		return flag;
	}

	/**
	 * @return the groupID
	 */
	public List<String> getRuleID() {
		return saledGood.getRuleID();
	}

	/**
	 * @param groupID
	 *            the groupID to set
	 */
	public void setRuleID(List<String> groupID) {
		saledGood.setRuleID(groupID);
	}

	/**
	 * @param saledDate
	 *            the saledDate to set
	 */
	public void setSaledDate(LocalDateTime saledDate) {
		saledGood.setSaledDate(saledDate);
	}

	/**
	 * @param goodID
	 *            the goodID to set
	 */
	public void setGoodID(String goodID) {
		super.setGoodID(goodID);
		saledGood.setGoodID(goodID);
	}

	/**
	 * @return the saled_date
	 */
	public LocalDateTime getSaledDate() {
		return saledGood.getSaledDate();
	}

	/**
	 * @return the sum
	 */
	public double getSum() {
		return saledGood.getSum();
	}

	/**
	 * @param sum
	 *            the sum to set
	 */
	public void setSum(double sum) {
		saledGood.setSum(sum);
	}

	/**
	 * @return the price
	 */
	public double getSaledPrice() {
		return saledGood.getPrice();
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setSaledPrice(double price) {
		saledGood.setPrice(price);
	}

	/**
	 * @return the orderID
	 */
	public String getOrderID() {
		return saledGood.getOrderID();
	}

	/**
	 * @param orderID
	 *            the orderID to set
	 */
	public void setOrderID(String orderID) {
		saledGood.setOrderID(orderID);
	}

	private void syncGood() {
		saledGood.setGoodID(getGoodID());
	}

}
