package com.jaemin.template;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class TestAdvisor {

	@PostConstruct
	public void init() {
		log.info("===== TestAdvisor initialized -=-=-=-=-");
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(Exception.class)
	public ModelAndView errorHandle(Exception ex) {
		log.info("CALL ===== errorHandle =====");
		return new ModelAndView("home");
	}
	
}
