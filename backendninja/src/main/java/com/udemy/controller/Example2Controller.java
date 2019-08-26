package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.udemy.constant.ViewConstant;

@Controller
@RequestMapping("/example2")
public class Example2Controller {
	
	private static final Log LOG = LogFactory.getLog(Example2Controller.class);

	//http://localhost:8080/example2/request1?nm=Juan
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name="nm", required=false,defaultValue="NULL") String name) {
		LOG.info("Example2Controller/request1");
		ModelAndView mav = new ModelAndView(ViewConstant.EXAMPLE_2);
		mav.addObject("nm_in_model", name);
		return mav;
	}
	
	//http://localhost:8080/example2/request2/Juan
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable("nm") String name) {
		LOG.info("Example2Controller/request2");
		ModelAndView mav = new ModelAndView(ViewConstant.EXAMPLE_2);
		mav.addObject("nm_in_model", name);
		return mav;
	}

}
