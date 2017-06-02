package com.superSaller.beans.security;

/**
 * @author ����ǿ
 * @version 1.0
 * @created 24-5��-2017 8:44:41
 */
public interface IDVerify {

	/**
	 * 
	 * @param userName
	 * @param passWord
	 */
	public IDVerifyStatus doVerify(String userName, String passWord);

}