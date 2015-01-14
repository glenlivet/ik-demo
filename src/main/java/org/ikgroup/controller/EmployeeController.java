package org.ikgroup.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ikgroup.domain.AjaxFeedback;
import org.ikgroup.domain.Employee;
import org.ikgroup.service.EmployeeService;
import org.ikgroup.util.UrlUtils;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/employees")
@Controller
public class EmployeeController {

	final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService empService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.POST)
	public String update(Employee employee, BindingResult bindingResult,
			Model uiModel, HttpServletRequest request,
			HttpServletResponse response,
			RedirectAttributes redirectAttributes, Locale locale) {
		logger.info("Updating employee");
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute(
					"message",
					new AjaxFeedback(AjaxFeedback.ERROR, messageSource
							.getMessage("employee_save_fail", new Object[] {},
									locale)));
			uiModel.addAttribute("employee", employee);
			return "employees/update";
		}
		uiModel.asMap().clear();
		redirectAttributes.addFlashAttribute(
				"message",
				new AjaxFeedback(AjaxFeedback.SUCCESS, messageSource
						.getMessage("employee_save_success", new Object[] {},
								locale)));
		empService.save(employee);
		return "redirect:/employees/"
				+ UrlUtils.encodeUrlPathSegment(employee.getId().toString(),
						request);
	}

	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") String id, Model uiModel) {
		uiModel.addAttribute("employee", empService.findById(id));
		return "employees/update";
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
	
	@RequestMapping(params = "form", method = RequestMethod.POST)
	public String create(Employee employee, BindingResult bindingResult,
			Model uiModel, HttpServletRequest request,
			HttpServletResponse response,
			RedirectAttributes redirectAttributes, Locale locale) {
		logger.info("creating employee");
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute(
					"message",
					new AjaxFeedback(AjaxFeedback.ERROR, messageSource
							.getMessage("employee_save_fail", new Object[] {},
									locale)));
			uiModel.addAttribute("employee", employee);
			return "employees/create";
		}
		uiModel.asMap().clear();
		redirectAttributes.addFlashAttribute(
				"message",
				new AjaxFeedback(AjaxFeedback.SUCCESS, messageSource
						.getMessage("employee_save_success", new Object[] {},
								locale)));
		empService.save(employee);
		return "redirect:/employees/"
				+ UrlUtils.encodeUrlPathSegment(employee.getId().toString(),
						request);
	}

	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createForm(Model uiModel) {
		Employee employee = new Employee();
		uiModel.addAttribute("employee", employee);
		return "employees/create";
	}
}
