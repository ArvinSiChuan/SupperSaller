package com.superSaller.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.stereotype.Service;

import com.superSaller.beans.checkout.entities.SaledGood;

@Service(value = "addGoodToOrderProcedure")
public class AddGoodToOrderProcedureSupport implements CallableStatementCallback<String> {
	private SaledGood saledGood;
	public String procedure;

	/**
	 * @return the saledGood
	 */
	public SaledGood getSaledGood() {
		return saledGood;
	}

	/**
	 * @param saledGood
	 *            the saledGood to set
	 */
	public void setSaledGood(SaledGood saledGood) {
		this.saledGood = saledGood;
		procedure = "{declare temp saled_goods%rowtype; " + "begin temp.good_id:='" + saledGood.getGoodID()
				+ "'; temp.saled_date:=to_date('" + saledGood.getSaledDate().toString() + "','yyyymmdd'); temp.sum:="
				+ saledGood.getSum() + ";" + "temp.price:=" + saledGood.getPrice() + ";" + " temp.order_id:='"
				+ saledGood.getOrderID() + "';" + "	checkout.add_good_to_order(temp); " + "end;}";
	}

	@Override
	public String doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
		if (saledGood != null) {

		}

		return "test";
	}

}
