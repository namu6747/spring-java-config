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

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages= {"com.jaemin.template.dao"})
public class DBConfig {
	
	@Autowired
    ApplicationContext context;
	
	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig("/prop/database.properties");
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}

	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(context.getResources("classpath:mybatis/sql/*.xml"));
        bean.setTypeAliasesPackage("com.jaemin.template.vo, com.jaemin.template.util");
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
