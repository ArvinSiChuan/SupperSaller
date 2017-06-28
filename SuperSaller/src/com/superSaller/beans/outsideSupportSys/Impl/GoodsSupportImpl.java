package com.superSaller.beans.outsideSupportSys.Impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superSaller.beans.outsideSupportSys.GoodIO;
import com.superSaller.beans.outsideSupportSys.entities.Good;

@Repository(value = "goodsSupport")
public class GoodsSupportImpl implements GoodIO {

	@Resource(name = "goodsList")
	private ArrayList<Good> goodsList;

	@Override
	public Good getGood(String goodID) {
		Good goodToGet = null;
		for (Good good : goodsList) {
			if (goodID.equals(good.getGoodID())) {
				goodToGet = good;
				break;
			}
		}
		return goodToGet;
	}

	@Override
	public ArrayList<Good> fuzzyQuery(String goodID) {
		ArrayList<Good> possibleGoods = new ArrayList<Good>();
		for (Good good : goodsList) {
			if (good.getGoodID().contains(goodID)) {
				possibleGoods.add(good);
			}
		}
		return possibleGoods;
	}

}
