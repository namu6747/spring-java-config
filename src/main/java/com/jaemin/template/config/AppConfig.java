package com.jaemin.template.config;

import java.time.Duration;
import java.util.List;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jaemin.template.exception.TestHandlerExceptionResolver;
import com.jaemin.template.interceptor.TestInterceptor;
import com.jaemin.template.typeconverter.TestConverter;
import com.jaemin.template.typeconverter.TestFormatter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan( basePackages = { "com.jaemin.template" }, 
				excludeFilters = @ComponentScan.Filter(
								type = FilterType.ANNOTATION,
								classes = Configuration.class
								)
			)
public class AppConfig implements WebMvcConfigurer {

	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		log.info("1.CALL =====AppConfig extendHandlerExceptionResolvers =====");
		resolvers.add(new TestHandlerExceptionResolver());
		for (HandlerExceptionResolver resolver : resolvers) {
			log.info(" ExceptionHandler resolver: {}", resolver);
		}
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		log.info("2.CALL =====AppConfig addFormatters =====");
		registry.addConverter(new TestConverter());
        registry.addFormatter(new TestFormatter());
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.info("3.CALL =====AppConfig addInterceptors =====");
		registry.addInterceptor(new TestInterceptor())
		.order(1)
		.addPathPatterns("/**");
		//.excludePathPatterns("/css/**","/*.ico", "/error", "/error-page/**");
	}

	
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.info("4.CALL =====AppConfig addResourceHandlers =====");
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/")
				.setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));;
		}
	

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		log.info("5.CALL =====AppConfig addArgumentResolvers =====");
		//resolvers.add(new TestArgumentResolver());
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		log.info("6.CALL =====AppConfig configureViewResolvers =====");
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

}
