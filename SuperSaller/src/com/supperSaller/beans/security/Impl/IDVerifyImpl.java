package com.supperSaller.beans.security.Impl;

import com.supperSaller.beans.persons.entities.CashSideEmployee;
import com.supperSaller.beans.security.IDVerify;
import com.supperSaller.beans.security.IDVerifyStatus;
import com.supperSaller.dao.CashSideEmpoyeeDAO;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:41
 */
public class IDVerifyImpl implements IDVerify {
	private CashSideEmpoyeeDAO dao;
	private CashSideEmployee employee;
	private IDVerifyStatus status = IDVerifyStatus.inValid;

	public IDVerifyImpl() {

	}

	/**
	 * 
	 * @param userName
	 * @param passWord
	 */
	public IDVerifyStatus doVerify(String userName, String passWord) {
		return null;
	}

}