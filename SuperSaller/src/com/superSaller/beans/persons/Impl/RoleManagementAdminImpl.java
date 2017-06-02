package com.superSaller.beans.persons.Impl;

import com.superSaller.beans.persons.AdministratorProcess;
import com.superSaller.beans.persons.entities.CashSideEmployee;
import com.superSaller.beans.persons.entities.EmRole;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:39
 */
public class RoleManagementAdminImpl extends CashSideEmployee implements AdministratorProcess {

	public RoleManagementAdminImpl() {

	}

	/**
	 * 
	 * @param operation
	 * @param role
	 */
	public EmRole doAdmin(String operation, EmRole role) {
		return null;
	}

}