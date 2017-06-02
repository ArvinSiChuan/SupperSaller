package com.superSaller.beans.checkout;

import java.util.Map;

import com.superSaller.beans.outsideSupportSys.entities.Good;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:40
 */
public interface GoodsImport {

	public Map<Good, Integer> getAllGoods();

	/**
	 * 
	 * @param good
	 */
	public boolean importGood(Good good);

	public boolean importGoods();

	/**
	 * 
	 * @param good
	 */
	public Good removeGood(Good good);

}