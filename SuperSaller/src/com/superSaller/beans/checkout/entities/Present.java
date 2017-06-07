package com.superSaller.beans.checkout.entities;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:41
 */
public class Present {

	private String presentConditionValue;
	private String presentDicountValue;
	private String presentID;
	private String presentType;
	private String ruleUUID;

	public Present() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param presentConditionValue
	 * @param presentDicountValue
	 * @param presentID
	 * @param presentType
	 * @param ruleUUID
	 */
	public Present(String presentConditionValue, String presentDicountValue, String presentID, String presentType,
			String ruleUUID) {
		super();
		this.presentConditionValue = presentConditionValue;
		this.presentDicountValue = presentDicountValue;
		this.presentID = presentID;
		this.presentType = presentType;
		this.ruleUUID = ruleUUID;
	}

	/**
	 * @return the presentConditionValue
	 */
	public String getPresentConditionValue() {
		return presentConditionValue;
	}

	/**
	 * @param presentConditionValue
	 *            the presentConditionValue to set
	 */
	public void setPresentConditionValue(String presentConditionValue) {
		this.presentConditionValue = presentConditionValue;
	}

	/**
	 * @return the presentDicountValue
	 */
	public String getPresentDicountValue() {
		return presentDicountValue;
	}

	/**
	 * @param presentDicountValue
	 *            the presentDicountValue to set
	 */
	public void setPresentDicountValue(String presentDicountValue) {
		this.presentDicountValue = presentDicountValue;
	}

	/**
	 * @return the presentID
	 */
	public String getPresentID() {
		return presentID;
	}

	/**
	 * @param presentID
	 *            the presentID to set
	 */
	public void setPresentID(String presentID) {
		this.presentID = presentID;
	}

	/**
	 * @return the presentType
	 */
	public String getPresentType() {
		return presentType;
	}

	/**
	 * @param presentType
	 *            the presentType to set
	 */
	public void setPresentType(String presentType) {
		this.presentType = presentType;
	}

	/**
	 * @return the ruleUUID
	 */
	public String getRuleUUID() {
		return ruleUUID;
	}

	/**
	 * @param ruleUUID
	 *            the ruleUUID to set
	 */
	public void setRuleUUID(String ruleUUID) {
		this.ruleUUID = ruleUUID;
	}

}