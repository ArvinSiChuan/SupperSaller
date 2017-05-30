package com.supperSaller.beans.outsideSupportSys.Impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.supperSaller.beans.outsideSupportSys.GoodIO;
import com.supperSaller.beans.outsideSupportSys.entities.Good;

@Service("goodsSupport")
public class GoodsSupportImpl implements GoodIO {

	private ArrayList<Good> goodsList;

	@Override
	public Good getGood(String goodID) {
		Good goodToGet = null;
		for (Good good : goodsList) {
			goodToGet = good.getGoodID() == goodID ? good : null;
		}
		return goodToGet;
	}

}
