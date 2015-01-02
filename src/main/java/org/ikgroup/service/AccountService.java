package org.ikgroup.service;

import java.util.List;

import org.ikgroup.domain.Account;

public interface AccountService {
	
	public List<Account> findAll();
	
	public Account save(Account account);
	
	public Account getById(Long id);
	
	
}
