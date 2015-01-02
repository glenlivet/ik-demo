package org.ikgroup.domain;

/**
 * 
 * 
 * @author glenlivet
 *
 */
public class Employee implements Person {
	
	/**
	 * Employee ID
	 */
	private String id;
	
	/**
	 * format: firstname  lastname
	 */
	private String fullname;
	
	/**
	 * 账号
	 */
	private Account account; 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
