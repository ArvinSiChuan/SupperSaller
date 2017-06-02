package com.superSaller.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.superSaller.beans.outsideSupportSys.entities.Good;

/**
 * @author 邱依强
 * @version 1.0
 * @created 24-05-2017 8:44:39
 */
@Controller
@RequestMapping("/cashier")
public class CashierController {

	public String createOrder() {
		return "";
	}

	public String doPayment() {
		return "";
	}

	public String importCustomer() {
		return "";
	}

	/**
	 * 
	 * @param goods
	 */
	public String importGoods(Set<Good> goods) {
		return "";
	}

	public String printTickets() {
		return "";
	}

	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String startCheckout() {
		return "/cashier/checkout";
	}

}