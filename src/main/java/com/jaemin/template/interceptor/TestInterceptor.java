package com.jaemin.template.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jaemin.template.vo.TestVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("START =====Interceptor preHandle=====");
		request.setAttribute("id", null);
		String id = request.getParameter("id");
		request.removeAttribute("id");
		String pw = request.getParameter("pw");
		log.info("preHandle id={}, pw={}", id,pw);
		log.info("request get null = {} ", request.getParameter("id"));
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
		if(response.getStatus() == 400) {
			// 응답이 이미 커밋된 후에는 sendRedirect를 호출할 수 없음
			// response.sendRedirect("home");
		}
		if(ex != null) {
			log.error(ex.getStackTrace().toString());
			
		}
		log.info("END =====Interceptor afterCompletion===== ");
	}
	
	

}
