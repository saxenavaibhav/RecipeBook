package com.saxena.vaibhav.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView handleNumberFormat(Exception ex) {
		log.error("Handling NumberFormatException");
		log.error(ex.getMessage());
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("nfe");
		modelAndView.addObject("exception", ex);
		return modelAndView;
	}
}
