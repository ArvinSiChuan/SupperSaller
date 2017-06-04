package com.superSaller.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.superSaller.beans.outsideSupportSys.GoodIO;
import com.superSaller.beans.outsideSupportSys.entities.Good;

@RestController
@RequestMapping("/goods")
public class GoodsRESTController {
	@Resource(name = "goodsSupport")
	private GoodIO goodsSupport;

	@RequestMapping(value = "/fuzzyQuery", method = RequestMethod.POST)
	public List<Good> fuzzyQueryGoods(String goodID) {
		return goodsSupport.fuzzyQuery(goodID);
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public Good queryGood(String goodID) {
		Good good = goodsSupport.getGood(goodID);
		return good;
	}

	@RequestMapping(value = "/fuzzyQueryID", method = RequestMethod.POST)
	public List<String> fuzzyQueryGoodsID(String goodID) {
		List<Good> goods = goodsSupport.fuzzyQuery(goodID);
		List<String> possibleID = new ArrayList<String>();
		for (Good good : goods) {
			possibleID.add(good.getGoodID());
		}
		return possibleID;
	}

}
