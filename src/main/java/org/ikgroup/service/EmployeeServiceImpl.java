package org.ikgroup.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.ikgroup.domain.Account;
import org.ikgroup.domain.Employee;
import org.ikgroup.pao.SequencePao;
import org.ikgroup.persistence.AccountMapper;
import org.ikgroup.persistence.EmployeeMapper;
import org.ikgroup.util.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
@Repository
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	public static final String SEQUENCE_KEY_EMPLOYEE = "empId";
	
	@Autowired
	private EmployeeMapper empMapper;
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private SequencePao sequencePao;

	@Override
	@Transactional(readOnly=true)
	public List<Employee> findAll() {
		return empMapper.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Employee findById(String id) {
		return empMapper.findById(id);
	}

	@Override
	public void save(Employee emp) {
		if(StringUtils.isEmpty(emp.getId().trim())){
			//新增
			Long id = sequencePao.getSequenceByName(SEQUENCE_KEY_EMPLOYEE);
			String idStr = NumberUtils.longToFixedString(id, 4);
			emp.setId(idStr);
			if(StringUtils.isEmpty(emp.getAccount().getPassword()))
				emp.getAccount().setPassword("123456");
			accountMapper.insert(emp.getAccount());
			empMapper.insert(emp);
		} else {
			//修改
			accountMapper.update(emp.getAccount());
			empMapper.update(emp);
		}
		
	}

}
