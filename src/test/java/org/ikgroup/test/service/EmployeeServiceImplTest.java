package org.ikgroup.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.ikgroup.domain.Account;
import org.ikgroup.service.AccountService;
import org.ikgroup.service.EmployeeService;
import org.ikgroup.test.annotation.DataSets;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImplTest extends AbstractServiceImplTest {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	AccountService accountService;
	
	@DataSets(setUpDataSet="/EmployeeServiceImplTest.xls")
	@Test
	public void testFindAll() throws Exception {
		List<Account> result = accountService.findAll();
		assertNotNull(result);
		assertEquals(1, result.size());
	}

}
