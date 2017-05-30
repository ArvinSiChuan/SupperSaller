package com.supperSaller.beans.payment.entities;

import java.util.Set;

import com.supperSaller.beans.checkout.OrderProcess;
import com.supperSaller.beans.payment.PaymentChannel;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:41
 */
public class Payment {

	private PaymentChannel paymentChannel;
	private int paymentChennelSideID;
	private String paymentID;
	private double paymentSum;
	private Set<OrderProcess> relatedOrders;

}