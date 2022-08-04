package com.jaemin.template.config;

import java.time.Duration;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
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
import com.jaemin.template.typeconverter.TestConverter;
import com.jaemin.template.typeconverter.TestFormatter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.jaemin.template" }, 
							excludeFilters = @ComponentScan.Filter(
									type = FilterType.ANNOTATION,
									classes = Configuration.class))
public class AppConfig implements WebMvcConfigurer {

	
	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		log.info("START =====AppConfig extendHandlerExceptionResolvers =====");
		resolvers.add(new TestHandlerExceptionResolver());
		for (HandlerExceptionResolver resolver : resolvers) {
			log.info("Add ExceptionHandler resolver: {}", resolver);
		}
		log.info("END =====AppConfig extendHandlerExceptionResolvers =====");
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		log.info("START =====AppConfig addFormatters =====");
		registry.addConverter(new TestConverter());
        registry.addFormatter(new TestFormatter());
        log.info("END =====AppConfig addFormatters =====");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.info("CALL =====AppConfig addInterceptors =====");
		registry.addInterceptor(new TestInterceptor())
		.order(1)
		.addPathPatterns("/add");
		//.excludePathPatterns("/css/**","/*.ico", "/error", "/error-page/**");
	}

	
	@Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.info("CALL =====AppConfig addResourceHandlers =====");
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/")
				.setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));;
		}
	

	//@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		log.info("CALL =====AppConfig addArgumentResolvers =====");
		resolvers.add(new TestArgumentResolver());
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		log.info("CALL =====AppConfig configureViewResolvers =====");
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
}
