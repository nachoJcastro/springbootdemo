package com.udemy.controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.udemy.constant.ViewConstant;

@ControllerAdvice
public class ErrorsController {
	
	private static final Log LOG = LogFactory.getLog(ErrorsController.class);
	
	@ExceptionHandler(Exception.class)
	public String showInternalServerError() {
		LOG.info("ErrorsController/showInternalServerError");
		return ViewConstant.ISE_VIEW;
	}

}
