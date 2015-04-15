package org.ikgroup.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.ikgroup.domain.BindingDomain;
import org.ikgroup.domain.BindingProperty;
import org.ikgroup.domain.TestConvDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test")
@Controller
public class TestRestController {
	
	final Logger logger = LoggerFactory.getLogger(TestRestController.class);
	
	@Autowired
	private TestConvDomain domain;
	
	@Inject
	@Named("conversionService")
	private ConversionService convService;
	
	@RequestMapping(value = "/conv", method = RequestMethod.POST)
	@ResponseBody
	public void convBirthday(){
		String birthday = convService.convert(domain.getBirthday(), String.class);
		logger.info("Birthday: " + birthday);
//		logger.info("Birthday: " + "aaaaaaaaa");
	}
	
	@RequestMapping(value = "/binding", method = RequestMethod.POST)
	@ResponseBody
	public void binding(BindingDomain bindingDomain){
		logger.info(bindingDomain.toString());
	}
	
	@RequestMapping(value = "/binding2", method = RequestMethod.POST)
	@ResponseBody
	public void binding(BindingProperty bindingProperty){
		logger.info(bindingProperty.toString());
	}
}
