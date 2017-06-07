package com.superSaller.beans.checkout;

import java.util.List;

import com.superSaller.beans.checkout.entities.ViewSideGood;

/**
 * @author 邱依强
 * @version 1.0
 * @created 24-05-2017 8:44:41
 */
public interface OrderProcess {

	public String createOrder();

	public List<ViewSideGood> addGoodAndMatch(ViewSideGood good);

	public List<ViewSideGood> removeGoodAndMatch(ViewSideGood good);

	public List<ViewSideGood> getAddedGoodsByOrder(String orderID);

	public void finishOrder();

}