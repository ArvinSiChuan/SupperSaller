package com.superSaller.beans.security.Impl;

import com.superSaller.beans.persons.entities.CashSideEmployee;
import com.superSaller.beans.security.IDVerify;
import com.superSaller.beans.security.IDVerifyStatus;
import com.superSaller.dao.CashSideEmployeeDAOImpl;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:41
 */
public class IDVerifyImpl implements IDVerify {
	private CashSideEmployeeDAOImpl dao;
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