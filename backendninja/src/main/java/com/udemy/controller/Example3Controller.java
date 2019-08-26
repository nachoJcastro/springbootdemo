package com.udemy.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.udemy.constant.ViewConstant;
import com.udemy.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

	private static final Log LOG = LogFactory.getLog(Example3Controller.class);
	
	@GetMapping("/")
	public RedirectView redirect() {
		LOG.info("Example3Controller/redirect");
		return new RedirectView("/example3/showform");
	}

	@GetMapping("/showform")
	public String showForm(Model model) {
		LOG.info("Example3Controller/showForm");
		model.addAttribute("person", new Person());
		return ViewConstant.FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson (@Valid @ModelAttribute("person") Person person, BindingResult bindingResult){
		LOG.info("Example3Controller/addPerson");
		ModelAndView mav = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mav.setViewName(ViewConstant.FORM_VIEW);
		}
		else {
			mav.setViewName(ViewConstant.RESULT_VIEW);
			mav.addObject("person",person);
		}
		return mav;
	}
	
}
