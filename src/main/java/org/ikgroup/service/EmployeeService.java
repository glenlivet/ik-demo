package org.ikgroup.service;

import java.util.List;

import org.ikgroup.domain.Employee;



public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(String id);
	
	public void save(Employee emp);

}
