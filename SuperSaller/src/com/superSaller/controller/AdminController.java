package com.superSaller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 邱依强
 * @version 1.0
 * @created 24-05-2017 8:44:38
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String toAdminMainPage() {
		return "/admin/rules";
	}
}