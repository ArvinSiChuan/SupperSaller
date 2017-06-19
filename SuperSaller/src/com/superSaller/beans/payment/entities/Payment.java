package com.superSaller.beans.payment.entities;

import java.util.Set;

import com.superSaller.beans.checkout.OrderProcess;
import com.superSaller.beans.payment.PaymentChannel;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:41
 */
public class Payment {

	private PaymentChannel paymentChannel;
	private String paymentChennelSideID;
	private String paymentID;
	private double paymentMoney;
	private Set<OrderProcess> relatedOrders;

}