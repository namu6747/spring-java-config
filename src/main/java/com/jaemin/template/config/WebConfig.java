package com.jaemin.template.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        // Servlet Spec 에 form data 는 포스트 형태로만 전송되지만 풋, 패치, 딜리트도 가능하게 만들어줌
		return new Filter[] { new FormContentFilter(), new HiddenHttpMethodFilter(), characterEncodingFilter};
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}
	
}
