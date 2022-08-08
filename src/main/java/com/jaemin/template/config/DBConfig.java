package com.jaemin.template.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Configuration
@MapperScan(basePackages = { "com.jaemin.template.dao" })
@Slf4j
public class DBConfig {

	@Autowired
	ApplicationContext context;

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig("/prop/database.properties");
		return new HikariDataSource(config);
	}
	
	@Bean
	public SqlSessionFactory fac(DataSource ds) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(ds);
		bean.setTypeAliasesPackage("com.jaemin.template.vo");
		bean.setMapperLocations(context.getResources("classpath:mybatis/sql/*.xml"));
		return bean.getObject();
	}

	@Bean
	public TransactionManager transactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
	
}
