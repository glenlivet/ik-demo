package org.ikgroup.domain;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

/**
 * 账号
 * 
 * @author glenlivet
 *
 */
public class Account {
	
	public static final int STATE_DELETED = -1;
	public static final int STATE_INACTIVE = 0;
	public static final int STATE_ACTIVE = 1;
	
	/**
	 * DB_ID
	 */
	private Long id;
	
	/**
	 * username
	 */
	private String username;
	
	/**
	 * password
	 */
	private String password;
	
	/**
	 * 状态标示
	 */
	private Integer stateFlag;
	
	/**
	 * 账号余额
	 */
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal balance = new BigDecimal(0);

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStateFlag() {
		return stateFlag;
	}

	public void setStateFlag(Integer stateFlag) {
		this.stateFlag = stateFlag;
	}

}
