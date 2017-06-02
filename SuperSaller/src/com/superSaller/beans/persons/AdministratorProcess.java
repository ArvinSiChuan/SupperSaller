package com.superSaller.beans.persons;

import com.superSaller.beans.persons.entities.EmRole;

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
	public EmRole doAdmin(String operation, EmRole role);

}