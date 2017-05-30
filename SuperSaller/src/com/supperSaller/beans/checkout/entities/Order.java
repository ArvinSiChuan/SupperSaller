package com.supperSaller.beans.checkout.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

import com.supperSaller.beans.checkout.DiscountMatcher;
import com.supperSaller.beans.outsideSupportSys.entities.Customer;
import com.supperSaller.beans.outsideSupportSys.entities.Good;
import com.supperSaller.beans.payment.entities.Payment;

public class Order {
	private ArrayList<Map<DiscountRule, Good>> avaliableMatcher;
	public DiscountMatcher discountMatcher;
	private Map<Map<Good, Integer>, Double> finalGoodsList;
	private LocalDateTime oderBuildDate;
	private String orderID;
	private Customer relatedCustomer;
	private DiscountRule relatedDiscountRule;
	private Payment relatedPayment;
	private double sum;
}
