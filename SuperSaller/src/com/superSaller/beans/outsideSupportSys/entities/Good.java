package com.superSaller.beans.outsideSupportSys.entities;

import javax.persistence.Entity;

/**
 * @author 邱依强
 * @version 1.0
 * @created 24-05-2017 8:44:40
 */
@Entity
public class Good {
	private String goodID;
	private String goodName;
	private String goodSpecifications;
	private double goodPrice;
	private String goodType;
	private String goodBrand;
	private String goodProducer;
	private String goodDesc;

	/**
	 * @param goodID
	 * @param goodName
	 * @param goodSpecifications
	 * @param goodPrice
	 * @param goodType
	 * @param goodBrand
	 * @param goodProducer
	 * @param goodDesc
	 */
	public Good() {

	}

	public Good(String goodID, String goodName, String goodSpecifications, double goodPrice, String goodType,
			String goodBrand, String goodProducer, String goodDesc) {
		super();
		this.goodID = goodID;
		this.goodName = goodName;
		this.goodSpecifications = goodSpecifications;
		this.goodPrice = goodPrice;
		this.goodType = goodType;
		this.goodBrand = goodBrand;
		this.goodProducer = goodProducer;
		this.goodDesc = goodDesc;
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
	 * @return the goodName
	 */
	public String getGoodName() {
		return goodName;
	}

	/**
	 * @param goodName
	 *            the goodName to set
	 */
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	/**
	 * @return the goodSpecifications
	 */
	public String getGoodSpecifications() {
		return goodSpecifications;
	}

	/**
	 * @param goodSpecifications
	 *            the goodSpecifications to set
	 */
	public void setGoodSpecifications(String goodSpecifications) {
		this.goodSpecifications = goodSpecifications;
	}

	/**
	 * @return the goodPrice
	 */
	public double getGoodPrice() {
		return goodPrice;
	}

	/**
	 * @param goodPrice
	 *            the goodPrice to set
	 */
	public void setGoodPrice(double goodPrice) {
		this.goodPrice = goodPrice;
	}

	/**
	 * @return the goodType
	 */
	public String getGoodType() {
		return goodType;
	}

	/**
	 * @param goodType
	 *            the goodType to set
	 */
	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}

	/**
	 * @return the goodBrand
	 */
	public String getGoodBrand() {
		return goodBrand;
	}

	/**
	 * @param goodBrand
	 *            the goodBrand to set
	 */
	public void setGoodBrand(String goodBrand) {
		this.goodBrand = goodBrand;
	}

	/**
	 * @return the goodProducer
	 */
	public String getGoodProducer() {
		return goodProducer;
	}

	/**
	 * @param goodProducer
	 *            the goodProducer to set
	 */
	public void setGoodProducer(String goodProducer) {
		this.goodProducer = goodProducer;
	}

	/**
	 * @return the goodDesc
	 */
	public String getGoodDesc() {
		return goodDesc;
	}

	/**
	 * @param goodDesc
	 *            the goodDesc to set
	 */
	public void setGoodDesc(String goodDesc) {
		this.goodDesc = goodDesc;
	}
}