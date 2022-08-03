package com.jaemin.template.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@ControllerAdvice
public class TestAdvice {

	@Around("execution(* com.jaemin.template.*.*(..))")
	public Object checkService(
			ProceedingJoinPoint pjp
		)throws Throwable{
	// 전처리
	log.info("===== around ServiceAdvice START =====");
	log.info("--- target : "+pjp.getTarget());
	log.info("--- method : "+pjp.getSignature().getName());
	log.info("--- params : "+Arrays.toString(pjp.getArgs()));
	Object o = pjp.proceed(); // 실체 메소드 실행
	// 후처리
	log.info("--- return value :" + o); 
	log.info("===== around ServiceAdvice END =====");
	return o;
}
}
