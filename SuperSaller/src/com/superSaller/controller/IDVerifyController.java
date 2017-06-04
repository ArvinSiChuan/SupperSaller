package com.superSaller.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 邱依强
 * @version 1.0
 * @created 24-05-2017 8:44:41
 */
@Controller
@RequestMapping("/auth")
public class IDVerifyController {

	@RequestMapping(value = "/login/", method = RequestMethod.GET)
	public String getLoginPage(HttpServletResponse response) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String redirectURL = "";
			UserDetails userDetails = (UserDetails) principal;
			List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(userDetails.getAuthorities());
			List<String> authStrings = new ArrayList<String>();
			for (GrantedAuthority grantedAuthority : authList) {
				authStrings.add(grantedAuthority.getAuthority());
				System.out.println(grantedAuthority.getAuthority());
			}
			if (authStrings.contains("ROLE_ADMIN")) {
				redirectURL = "../../";
			} else if (authStrings.contains("ROLE_CASHIER")) {
				redirectURL = "../../cashier/start";
			}
			try {
				response.sendRedirect(redirectURL);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "login/index";

	}
}