package com.supperSaller.dao;

import java.util.Set;

import com.supperSaller.beans.persons.entities.EmIdentity;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:39
 */
public interface CashSideEmpoyeeDAO {

	/**
	 * 
	 * @param emID
	 */
	public Set<EmIdentity> queryEmIdentity(String emID);

}