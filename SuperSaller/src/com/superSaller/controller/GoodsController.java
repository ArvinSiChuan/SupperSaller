package com.superSaller.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.superSaller.beans.outsideSupportSys.GoodIO;
import com.superSaller.beans.outsideSupportSys.entities.Good;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	@Resource(name = "goodsSupport")
	private GoodIO goodsSupport;

	@RequestMapping(value = "/fuzzyQuery", method = RequestMethod.POST)
	public List<Good> fuzzyQueryGoods(String goodID) {
		return goodsSupport.fuzzyQuery(goodID);
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public Good queryGood(String goodID) {
		Good good = goodsSupport.getGood(goodID);
		System.out.println(good.getGoodName());
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

	@RequestMapping(value = "/addGood/{orderid}/{quantity}", method = RequestMethod.PUT)
	public List<Good> addGoodToOrder(@RequestBody Good good, @PathVariable("orderid") String orderID,
			@PathVariable("quantity") int quantity) {
		return null;
	}

}
