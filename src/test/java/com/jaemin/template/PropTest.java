package com.jaemin.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jaemin.template.config.AppConfig;
import com.jaemin.template.config.RootConfig;
import com.jaemin.template.config.WebConfig;

import lombok.extern.slf4j.Slf4j;

@PropertySource("classpath:prop/database.properties")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@Slf4j
public class PropTest {
	
	@Value("${jdbc.driver}") 
	String str;
	
	@Autowired
	ApplicationContext ac; // = new AnnotationConfigApplicationContext(WebConfig.class);
	
	@Test
	public void test() {
		log.info(ac.getId());
		log.info(str);
		for(Object obj : ac.getBeanDefinitionNames()) {
			log.info(obj.toString());
		}
		
	}

}
