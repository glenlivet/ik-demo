package org.ikgroup.service;

import java.util.List;

import org.ikgroup.domain.Employee;
import org.ikgroup.persistence.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
@Repository
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeMapper empMapper;

	@Override
	public List<Employee> findAll() {
		return empMapper.findAll();
	}

}
