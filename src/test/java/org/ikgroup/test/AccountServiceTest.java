package org.ikgroup.test;

import static org.junit.Assert.*;

import java.util.List;

import org.ikgroup.domain.Account;
import org.ikgroup.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AccountServiceTest {
	
	@Test
	public void Test() {
		GenericXmlApplicationContext ctx;
		ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring-ds.xml");
		ctx.refresh();
		
		AccountService as = ctx.getBean("accountService", AccountService.class);
		
		Account a1 = new Account();
		a1.setUsername("kikyou");
		a1.setPassword("kikyou");
		
		a1 = as.save(a1);
		assertNotNull(a1.getId());
		
		List<Account> accs = as.findAll();
		assertEquals(accs.size(), 1);
		
		Account a2 = as.findById(a1.getId());
		assertEquals(a2.getUsername(), a1.getUsername());
		assertEquals(a2.getPassword(), null);
		
		a2.setStateFlag(Account.STATE_INACTIVE);
		a2 = as.save(a2);
		
		Account a3 = new Account();
		a3.setUsername("kikyou");
		a3.setPassword("kikyou");
		boolean valid = as.isValidAccount(a3);
		assertEquals(valid, false);
		
		
		
		
	}

}
