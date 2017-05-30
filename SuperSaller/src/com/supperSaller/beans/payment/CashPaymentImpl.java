package com.supperSaller.beans.payment;

import com.supperSaller.beans.payment.entities.Payment;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:39
 */
public class CashPaymentImpl extends Payment implements PaymentProcess {

	public CashPaymentImpl() {

	}

	public boolean doPayment() {
		return false;
	}

}