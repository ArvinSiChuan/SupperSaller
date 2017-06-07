package com.superSaller.controller.REST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.superSaller.beans.checkout.entities.DiscountRule;
import com.superSaller.dao.DiscountGoodsDAO;
import com.superSaller.dao.RuleDAO;

@RestController
@RequestMapping("/rule")
public class RuleRESTController {
	@Resource(name = "ruleDAO")
	private RuleDAO ruleDAO;

	@Resource(name = "discountGoodsDAO")
	private DiscountGoodsDAO discountGoodsDAO;

	@RequestMapping(value = "/{uuid}", method = RequestMethod.POST)
	public DiscountRule qureyRuleByID(@PathVariable(value = "uuid") String uuid) {
		return ruleDAO.queryRuleByID(uuid);
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public DiscountRule addRule(@RequestBody DiscountRule rule) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		rule.setUUID(uuid);
		return ruleDAO.addRule(rule);
	}

	@RequestMapping(value = "/{uuid}/good/", method = RequestMethod.PUT)
	public Map<String, Boolean> addGoodToRule(@PathVariable("uuid") String ruleUUID, String goodID, double sum) {
		boolean flag = discountGoodsDAO.addGoodToRule(ruleUUID, goodID, sum);
		Map<String, Boolean> status = new HashMap<String, Boolean>();
		status.put("status", flag);
		return status;
	}

	@RequestMapping(value = "/{emid}/all", method = RequestMethod.POST)
	public List<DiscountRule> queryAllRulesByEm(@PathVariable("emid") String emID) {
		System.out.println(emID);
		return ruleDAO.queryRulesByEm(emID);
	}

	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public List<DiscountRule> queryAllRules() {
		return ruleDAO.queryAllRules();
	}
}
