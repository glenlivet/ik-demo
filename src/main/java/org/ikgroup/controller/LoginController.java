package org.ikgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping("/login")
@Controller
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String show(Model uiModel){
		return "login/index";
	}
	
	

}
