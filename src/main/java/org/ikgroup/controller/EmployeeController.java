package org.ikgroup.controller;

import java.util.List;

import org.ikgroup.domain.Employee;
import org.ikgroup.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/employees")
@Controller
public class EmployeeController {

	final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService empService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel){
		 logger.info("listing employees");
		 
		 List<Employee> emps = empService.findAll();
		 uiModel.addAttribute("employees", emps);
		 
		 logger.info("No. of employees: " + emps.size());
		 
		 return "employees/list"; 
	}
}
