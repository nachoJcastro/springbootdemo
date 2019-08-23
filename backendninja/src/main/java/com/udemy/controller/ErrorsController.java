package com.udemy.controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.udemy.constant.ViewConstant;

@ControllerAdvice
public class ErrorsController {
	
	@ExceptionHandler(Exception.class)
	public String showInternalServerError() {
		return ViewConstant.ISE_VIEW;
	}

}
