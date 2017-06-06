package com.superSaller.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.superSaller.beans.checkout.entities.DiscountRule;
import com.superSaller.dao.RuleDAO;

@RestController
@RequestMapping("/rule")
public class RuleRESTController {
	@Resource(name = "ruleDAO")
	private RuleDAO ruleDAO;

	@RequestMapping(value = "/{uuid}", method = RequestMethod.POST)
	public DiscountRule qureyRuleByID(@PathVariable(value = "uuid") String uuid) {
		return ruleDAO.queryRuleByID(uuid);
	}

	@RequestMapping(value = "/new", method = RequestMethod.PUT)
	public DiscountRule addRule(@RequestBody DiscountRule rule) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		rule.setUUID(uuid);
		return ruleDAO.addRule(rule);
	}

	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public List<DiscountRule> queryAllRulesByEm(String emID) {
		System.out.println(emID);
		return ruleDAO.queryRulesByEm(emID);
	}
}
