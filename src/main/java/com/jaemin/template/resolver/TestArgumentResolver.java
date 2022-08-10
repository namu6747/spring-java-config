package com.jaemin.template.resolver;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.jaemin.template.vo.TestVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestArgumentResolver implements HandlerMethodArgumentResolver {
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {

		log.info("============ArgumentResolver supportsParameter start ============");
		log.info("TestArgumentResolver supportsParameter call");
		log.info(Arrays.toString(getClass().getMethods()));
		log.info(parameter.getMethod().getName());
		
		boolean hasTestAnnotation = parameter.hasParameterAnnotation(Checker.class);
		boolean hasMemberType = TestVO.class.isAssignableFrom(parameter.getParameterType());
		
		log.info("============ArgumentResolver supportsParameter end ============");
		return hasTestAnnotation && hasMemberType;
	}
	
	// 컨버터 제거 후 전체 정상 동작  ***********

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		log.info("============ArgumentResolver resolveArgument start ============");
		
		webRequest.getParameterNames().forEachRemaining(obj -> log.info("parameter = {}",obj));
		
		HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest();//.getNativeRequest();
		request.getParameterMap().values().stream().forEach(obj -> log.info("request Value = {} ", obj));
		log.info("request URL = {}",request.getRequestURL());
		log.info("request Addr ={}", request.getRemoteAddr());
		log.info("request Host ={}", request.getRemoteHost());
		log.info("============ArgumentResolver resolveArgument end ============");
		String id = request.getParameter("id");
		log.info("id = {}", id);
		if(id.equals(""))id = null;
		String pw = request.getParameter("pw");
		return new TestVO(null,pw);
	}

}
