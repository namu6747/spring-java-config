package com.jaemin.template.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Import;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lombok.extern.slf4j.Slf4j;

// Abstract~ 상속하면 톰캣이 배포 서술자로 인식
@Slf4j
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("CALL =====WebConfig getRootConfigClasses =====");
		return new Class[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.info("CALL =====WebConfig getServletConfigClasses =====");
		return new Class[] { AppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		log.info("CALL =====WebConfig getServletMappings =====");
		return new String[] { "/" };
	}

	@Override // 톰캣에  필터 다는 건 당연한 듯
	protected Filter[] getServletFilters() {
		log.info("CALL =====WebConfig getServletFilters =====");
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
		return new Filter[] { characterEncodingFilter };
	}
	
	

}
