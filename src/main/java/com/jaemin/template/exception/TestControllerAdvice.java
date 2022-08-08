package com.jaemin.template.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
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
