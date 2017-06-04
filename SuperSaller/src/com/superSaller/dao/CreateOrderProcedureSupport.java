package com.superSaller.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.stereotype.Service;

import oracle.jdbc.OracleTypes;

@Service("createOrderProcedure")
public class CreateOrderProcedureSupport implements CallableStatementCallback<String> {
	public final String procedure = "call checkout.create_order(?,?)";
	private String emid = "________";

	/**
	 * @return the emid
	 */
	public String getEmid() {
		return emid;
	}

	/**
	 * @param emid
	 *            the emid to set
	 */
	public void setEmid(String emid) {
		this.emid = emid;
	}

	@Override
	public String doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
		cs.setString(1, emid);
		cs.registerOutParameter(2, OracleTypes.CHAR);
		cs.execute();
		return cs.getString(2);
	}

}
