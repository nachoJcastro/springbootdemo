package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.constant.ViewConstant;
import com.udemy.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	private static final Log LOG = LogFactory.getLog(ExampleController.class);
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	
	//Ejemplo Forma 1
	@GetMapping("/exampleString")
	public	String exampleString(Model model) {
		LOG.info("ExampleController/exampleString");
		exampleComponent.sayHello();
		model.addAttribute("people",exampleService.getListPeople());
		return ViewConstant.EXAMPLE;
	}
	
	//Ejemplo Forma 2
	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV() {
		LOG.info("ExampleController/exampleMAV");
		exampleComponent.sayHello();
		ModelAndView mav= new ModelAndView(ViewConstant.EXAMPLE);
		mav.addObject("people",exampleService.getListPeople());
		return mav;
	}

}
