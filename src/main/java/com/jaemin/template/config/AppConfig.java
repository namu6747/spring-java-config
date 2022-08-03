package com.jaemin.template.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jaemin.template.exception.TestHandlerExceptionResolver;
import com.jaemin.template.interceptor.TestInterceptor;
import com.jaemin.template.resolver.TestArgumentResolver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.jaemin.template.controller"}) 
public class AppConfig implements WebMvcConfigurer {

	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		resolvers.add(new TestHandlerExceptionResolver());
		for (HandlerExceptionResolver resolver : resolvers) {
			log.info("Add ExceptionHandler resolver: {}", resolver);
		}
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		log.info("FormatterRegistry = {}",registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new TestInterceptor())
		.order(1)
		.addPathPatterns("/**");
		//.excludePathPatterns("/css/**","/*.ico", "/error", "/error-page/**");
	}

	
	@Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/"); }
	

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new TestArgumentResolver());
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
}
