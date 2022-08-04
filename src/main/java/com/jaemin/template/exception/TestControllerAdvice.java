package com.jaemin.template.exception;

import org.omg.CORBA.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class TestControllerAdvice {
	
	/*
	 * @ResponseStatus(HttpStatus.BAD_REQUEST)
	 * 
	 * @ExceptionHandler(Exception.class) public ErrorResult
	 * illegalExHandle(Exception e){ log.error("===== [exceptionHandle] ex ", e);
	 * return new ErrorResult("BAD", e.getMessage()); }
	 */
	
//	@ExceptionHandler(Exception.class)
//		public String nullex(Exception e) {
//	        System.err.println(e.getClass());
//	        return "404";
//	    }
}
