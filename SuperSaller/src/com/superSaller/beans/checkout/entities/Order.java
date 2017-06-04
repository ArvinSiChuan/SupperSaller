package com.superSaller.beans.checkout.entities;

import java.util.Set;

import javax.persistence.Entity;

import com.superSaller.beans.outsideSupportSys.entities.Customer;
import com.superSaller.beans.outsideSupportSys.entities.Good;
import com.superSaller.beans.payment.entities.Payment;
import com.superSaller.beans.persons.entities.CashSideEmployee;

@Entity
public class Order {
	private String orderID;
	private Set<Good> goodsList;
	private int orderSum;
	private double sumMoney;
	private Customer relatedCustomer;
	private Set<DiscountRule> relatedDiscountRules;
	private Payment relatedPayment;
	private CashSideEmployee employee;
	private String status;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param orderID
	 * @param goodsList
	 * @param orderSum
	 * @param sumMoney
	 * @param relatedCustomer
	 * @param relatedDiscountRules
	 * @param relatedPayment
	 * @param employee
	 */
	public Order(String orderID, Set<Good> goodsList, int orderSum, double sumMoney, Customer relatedCustomer,
			Set<DiscountRule> relatedDiscountRules, Payment relatedPayment, CashSideEmployee employee, String status) {
		super();
		this.orderID = orderID;
		this.goodsList = goodsList;
		this.orderSum = orderSum;
		this.sumMoney = sumMoney;
		this.relatedCustomer = relatedCustomer;
		this.relatedDiscountRules = relatedDiscountRules;
		this.relatedPayment = relatedPayment;
		this.employee = employee;
		this.status = status;
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

	/**
	 * @return the goodsList
	 */
	public Set<Good> getGoodsList() {
		return goodsList;
	}

	/**
	 * @param goodsList
	 *            the goodsList to set
	 */
	public void setGoodsList(Set<Good> goodsList) {
		this.goodsList = goodsList;
	}

	/**
	 * @return the orderSum
	 */
	public int getOrderSum() {
		return orderSum;
	}

	/**
	 * @param orderSum
	 *            the orderSum to set
	 */
	public void setOrderSum(int orderSum) {
		this.orderSum = orderSum;
	}

	/**
	 * @return the sumMoney
	 */
	public double getSumMoney() {
		return sumMoney;
	}

	/**
	 * @param sumMoney
	 *            the sumMoney to set
	 */
	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}

	/**
	 * @return the relatedCustomer
	 */
	public Customer getRelatedCustomer() {
		return relatedCustomer;
	}

	/**
	 * @param relatedCustomer
	 *            the relatedCustomer to set
	 */
	public void setRelatedCustomer(Customer relatedCustomer) {
		this.relatedCustomer = relatedCustomer;
	}

	/**
	 * @return the relatedDiscountRules
	 */
	public Set<DiscountRule> getRelatedDiscountRules() {
		return relatedDiscountRules;
	}

	/**
	 * @param relatedDiscountRules
	 *            the relatedDiscountRules to set
	 */
	public void setRelatedDiscountRules(Set<DiscountRule> relatedDiscountRules) {
		this.relatedDiscountRules = relatedDiscountRules;
	}

	/**
	 * @return the relatedPayment
	 */
	public Payment getRelatedPayment() {
		return relatedPayment;
	}

	/**
	 * @param relatedPayment
	 *            the relatedPayment to set
	 */
	public void setRelatedPayment(Payment relatedPayment) {
		this.relatedPayment = relatedPayment;
	}

	/**
	 * @return the employee
	 */
	public CashSideEmployee getEmployee() {
		return employee;
	}

	/**
	 * @param employee
	 *            the employee to set
	 */
	public void setEmployee(CashSideEmployee employee) {
		this.employee = employee;
	}

}
