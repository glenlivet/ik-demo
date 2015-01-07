package org.ikgroup.persistence;

import java.util.List;

import org.ikgroup.domain.Employee;

public interface EmployeeMapper {
	
	public void insert(Employee employee);
	
	public void update(Employee employee);
	
	public List<Employee> findAll();
	
	public Employee findById(String id);
	
	public void delete(String id);
	
	public Long getTotal();

}
