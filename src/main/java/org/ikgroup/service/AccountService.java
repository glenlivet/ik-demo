package org.ikgroup.service;

import java.util.List;

import org.ikgroup.domain.Account;

public interface AccountService {
	
	public List<Account> findAll();
	
	public Account save(Account account);
	
	public Account findById(long id);
	
	public boolean isValidAccount(Account account);
	
	public void delete(long id);
	
}
