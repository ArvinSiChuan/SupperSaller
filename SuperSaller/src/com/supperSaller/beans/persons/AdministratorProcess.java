package com.supperSaller.beans.persons;

import com.supperSaller.beans.persons.entities.EmIdentity;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:39
 */
public interface AdministratorProcess {

	/**
	 * 
	 * @param operation
	 * @param role
	 */
	public EmIdentity doAdmin(String operation, EmIdentity role);

}