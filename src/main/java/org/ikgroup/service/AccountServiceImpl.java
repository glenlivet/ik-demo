package org.ikgroup.service;

import java.util.List;

import org.ikgroup.domain.Account;
import org.ikgroup.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Repository
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public List<Account> findAll() {
		
		return accountMapper.findAll();
	}

	@Override
	public Account save(Account account) {
		if(account.getId() == null){
			//save new
			accountMapper.insert(account);
		}else {
			// update
			accountMapper.update(account);
		}
		
		return account;
	}

	@Override
	public Account findById(long id) {
		
		return accountMapper.findById(id);
	}

	@Override
	public boolean isValidAccount(Account account) {
		Account acc = accountMapper.findByUsernameAndPassword(account);
		return acc == null?false:true;
	}

	@Override
	public void delete(long id) {
		accountMapper.delete(id);
	}

	

}
