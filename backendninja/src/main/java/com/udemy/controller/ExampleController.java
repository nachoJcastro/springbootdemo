package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.udemy.constant.ViewConstant;
import com.udemy.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {

	//Ejemplo Forma 1
	@GetMapping("/exampleString")
	public	String exampleString(Model model) {
		model.addAttribute("people",getPeople());
		return ViewConstant.EXAMPLE;
	}
	
	//Ejemplo Forma 2
	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV() {
		ModelAndView mav= new ModelAndView(ViewConstant.EXAMPLE);
		mav.addObject("people",getPeople());
		return mav;
	}
	
	private List<Person> getPeople(){
		List<Person> people = new ArrayList<>();
		people.add(new Person("Juan",10));
		people.add(new Person("Ana",11));
		people.add(new Person("Nacho",12));
		people.add(new Person("Carlos",13));
		people.add(new Person("Nati",14));
		return people;
	}

}
