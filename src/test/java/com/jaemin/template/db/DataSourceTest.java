package com.jaemin.template.db;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jaemin.template.config.AppConfig;
import com.jaemin.template.config.DBConfig;
import com.jaemin.template.config.WebConfig;
import com.jaemin.template.dao.TestDAO;
import com.jaemin.template.vo.TestVO;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class, DBConfig.class})
@WebAppConfiguration
public class DataSourceTest {
	
	@Autowired
	ApplicationContext ac;
	@Autowired
	TestDAO dao;

	// @Test
	public void 히카리() throws InterruptedException {
			log.info("CALL =====DBConfig dataSource =====");
			HikariConfig config = new HikariConfig("/prop/database.properties");
			config.setPoolName("template");
			config.setAutoCommit(false);
			config.setMaximumPoolSize(10);
			config.setMinimumIdle(1);
			HikariDataSource ds = new HikariDataSource(config);
			log.info(ds.toString());
			
			Thread.sleep(1000);
	}
	
	//@Transactional
	@Test
	public void 트랜잭션() {
		log.info("start");
		dao.save(new TestVO("id005", "id005"));
		//dao.save(new TestVO("id005", "id005"));
		
	}
	
}
