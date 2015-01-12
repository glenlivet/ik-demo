package org.ikgroup.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ikgroup.domain.Account;
import org.ikgroup.domain.AjaxFeedback;
import org.ikgroup.domain.Employee;
import org.ikgroup.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/employees")
@Controller
public class EmployeeController {

	final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.POST)
	public String update(Employee employee, Account account,
			BindingResult bindingResult, Model uiModel,
			HttpServletRequest request, HttpServletResponse response,
			Locale locale) {
		logger.info("Updating contact");
		if(bindingResult.hasErrors()){
			uiModel.addAttribute(
					"message",
					new AjaxFeedback(-1, messageSource.getMessage(
							"employee_save_fail", new Object[] {}, locale)));
			//TODO
		}
		
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, Model uiModel) {
		Employee emp = empService.findById(id);
		uiModel.addAttribute("employee", emp);
		return "employees/show";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		logger.info("listing employees");

		List<Employee> emps = empService.findAll();
		uiModel.addAttribute("employees", emps);

		logger.info("No. of employees: " + emps.size());

		return "employees/list";
	}
}
