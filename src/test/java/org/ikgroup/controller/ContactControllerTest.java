package org.ikgroup.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.ikgroup.domain.Account;
import org.ikgroup.domain.Employee;
import org.ikgroup.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

public class ContactControllerTest extends AbstractControllerTest {

	private final List<Employee> employees = new ArrayList<Employee>();

	private EmployeeService employeeService;

	@Before
	public void initEmployees() {
		Account a = new Account();
		a.setId(1l);
		a.setUsername("tt.t");
		a.setPassword("pwd");
		a.setStateFlag(Account.STATE_ACTIVE);
		a.setBalance(new BigDecimal(0));

		Employee e = new Employee();
		e.setId("testId1L");
		e.setFirstname("Testy");
		e.setLastname("Tester");
		e.setInitials("T.Tester");
		e.setStateFlag(Employee.STATE_ON_JOB);
		e.setAccount(a);
		employees.add(e);
	}

	@Test
	public void testList() throws Exception {
		employeeService = mock(EmployeeService.class);
		when(employeeService.findAll()).thenReturn(employees);

		EmployeeController employeeController = new EmployeeController();

		ReflectionTestUtils.setField(employeeController, "empService",
				employeeService);

		ExtendedModelMap uiModel = new ExtendedModelMap();

		String result = employeeController.list(uiModel);

		assertNotNull(result);
		assertEquals(result, "employees/list");

		List<Employee> modelEmployees = (List<Employee>) uiModel
				.get("employees");

		assertEquals(1, modelEmployees.size());

	}
	
	public void testCreate() {
		
	}

}
