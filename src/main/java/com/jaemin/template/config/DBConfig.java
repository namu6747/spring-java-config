package com.jaemin.template.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Configuration
@MapperScan(basePackages= {"com.jaemin.template.dao"})
@Slf4j
public class DBConfig {
	
	@Autowired
    ApplicationContext context;
	
	@Bean
	public DataSource dataSource() {
		log.info("CALL =====DBConfig dataSource =====");
		HikariConfig config = new HikariConfig("/prop/database.properties");
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(DataSource ds) throws Exception {
		log.info("CALL =====DBConfig sqlSessionTemplate =====");
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        bean.setMapperLocations(context.getResources("classpath:mybatis/sql/*.xml"));
        bean.setTypeAliasesPackage("com.jaemin.template.vo");
        SqlSessionFactory fac = bean.getObject();
        return new SqlSessionTemplate(fac);
	}
	

}
