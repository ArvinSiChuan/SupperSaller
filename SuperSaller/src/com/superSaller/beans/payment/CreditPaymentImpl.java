package com.superSaller.beans.payment;

import com.superSaller.beans.payment.entities.Payment;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:39
 */
public class CreditPaymentImpl extends Payment implements PaymentProcess {

	public CreditPaymentImpl() {

	}

	public boolean doPayment() {
		return false;
	}

}