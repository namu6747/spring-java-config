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

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		log.info("============ArgumentResolver resolveArgument start ============");
		
		HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest();
		
		log.info("request Addr ={}", request.getRemoteAddr());
		log.info("request Host ={}", request.getRemoteHost());
		ModelMap mm = mavContainer.getModel();
		mm.keySet().stream().forEach(key -> 
			log.info("resolveArgument key={}, value={}",key,mm.get(key))
		);
		log.info("vo = {}",request.getAttribute("testVO"));
		log.info("id = {} , pw = {} ",request.getAttribute("id"),request.getAttribute("pw"));
		log.info("============ArgumentResolver resolveArgument end ============");
		return new TestVO("0","0");
	}

}
