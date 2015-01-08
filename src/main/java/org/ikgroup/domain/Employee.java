package org.ikgroup.domain;

/**
 * 职员
 * 
 * @author glenlivet
 *
 */
public class Employee implements SysUser {
	
	public static final int STATE_LEFT = -1;
	public static final int STATE_RETIRED = 0;
	public static final int STATE_ON_JOB = 1;
	
	/**
	 * Employee ID
	 */
	private String id;
	
	private String firstname;
	
	private String lastname;
	
	/**
	 * 姓名英文首字缩写
	 */
	private String initials;
	
	/**
	 * format: firstname  lastname
	 */
	private String fullname;
	
	/**
	 * 账号
	 */
	private Account account; 
	
	/**
	 * 状态标识
	 */
	private Integer stateFlag;

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

	public Integer getStateFlag() {
		return stateFlag;
	}

	public void setStateFlag(Integer stateFlag) {
		this.stateFlag = stateFlag;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

}
