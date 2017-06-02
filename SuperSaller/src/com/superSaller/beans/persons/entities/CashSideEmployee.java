package com.superSaller.beans.persons.entities;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:39
 */
public class CashSideEmployee {

	private EmRole emRole;
	private String emID;

	public CashSideEmployee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param emRole
	 * @param emID
	 */
	public CashSideEmployee(EmRole emRole, String emID) {
		super();
		this.emRole = emRole;
		this.emID = emID;
	}

	/**
	 * @return the emRole
	 */
	public EmRole getEmRole() {
		return emRole;
	}

	/**
	 * @param emRole
	 *            the emRole to set
	 */
	public void setEmRole(EmRole emRole) {
		this.emRole = emRole;
	}

	/**
	 * @return the emID
	 */
	public String getEmID() {
		return emID;
	}

	/**
	 * @param emID
	 *            the emID to set
	 */
	public void setEmID(String emID) {
		this.emID = emID;
	}

}