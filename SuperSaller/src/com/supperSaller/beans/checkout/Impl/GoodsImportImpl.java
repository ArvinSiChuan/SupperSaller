package com.supperSaller.beans.checkout.Impl;

import java.util.Map;

import com.supperSaller.beans.checkout.GoodsImport;
import com.supperSaller.beans.outsideSupportSys.entities.Good;

public class GoodsImportImpl implements GoodsImport {

	private Map<Good, Integer> importedGoods;

	@Override
	public Map<Good, Integer> getAllGoods() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean importGood(Good good) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean importGoods() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Good removeGood(Good good) {
		// TODO Auto-generated method stub
		return null;
	}

}
