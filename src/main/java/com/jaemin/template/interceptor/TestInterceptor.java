package com.jaemin.template.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("START =====Interceptor preHandle=====");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		log.info("preHandle id={}, pw={}", id,pw);
		log.info("END =====Interceptor preHandle=====");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("START =====Interceptor postHandle===== END");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("START =====Interceptor afterCompletion===== ");
		log.info("status code = {}",response.getStatus());
		if(ex != null) {
			log.error(ex.getStackTrace().toString());
			
		}
		log.info("END =====Interceptor afterCompletion===== ");
	}
	
	

}
