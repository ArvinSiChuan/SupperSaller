package com.supperSaller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:41
 */
@Controller
@RequestMapping("/auth")
public class IDVerifyController {

	@RequestMapping(value = "/login/", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login/index";
	}
}