package com.supperSaller.beans.persons.Impl;

import com.supperSaller.beans.persons.AdministratorProcess;
import com.supperSaller.beans.persons.entities.CashSideEmployee;
import com.supperSaller.beans.persons.entities.EmIdentity;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:41
 */
public class SystemAdminImpl extends CashSideEmployee implements AdministratorProcess {

	public RoleManagementAdminImpl m_AdminRoleManagerImpl;

	public SystemAdminImpl() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param operation
	 * @param role
	 */
	public EmIdentity doAdmin(String operation, EmIdentity role) {
		return null;
	}

}