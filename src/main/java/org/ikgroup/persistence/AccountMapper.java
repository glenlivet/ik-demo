package org.ikgroup.persistence;

import java.util.List;

import org.ikgroup.domain.Account;

public interface AccountMapper {
	
	public void insert(Account account);
	
	public void update(Account account);
	
	public List<Account> findAll();
	
	public Account findById(Long id);
	
	public void delete(Long id);
	
	public Account findByUsernameAndPassword(String username, String password);

}
