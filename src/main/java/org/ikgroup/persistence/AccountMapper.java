package org.ikgroup.persistence;

import java.util.List;

import org.ikgroup.domain.Account;

public interface AccountMapper {
	
	public void insert(Account account);
	
	public void update(Account account);
	
	public List<Account> findAll();
	
	public Account findById(long id);
	
	public void delete(long id);
	
	public Account findByUsernameAndPassword(Account account);

}
