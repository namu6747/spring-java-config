package com.jaemin.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@PropertySource("classpath:prop/database.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class PropTest {
	
	@Value("${jdbc.driver}") String str;
	
	@Test
	public void test() {
		System.out.println(str);
	}

}
