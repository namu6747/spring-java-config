package com.jaemin.template;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaemin.template.config.AppConfig;
import com.jaemin.template.config.RootConfig;
import com.jaemin.template.config.WebConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestApp {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(WebConfig.class);
		ac.register(RootConfig.class);
		ac.register(AppConfig.class);
		ac.refresh();
		for(Object obj : ac.getBeanDefinitionNames()) {
			log.info("class = {} , toString = {} ",obj.getClass(),obj.toString() );
		}
	}
}
