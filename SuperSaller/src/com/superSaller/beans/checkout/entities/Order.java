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

}
