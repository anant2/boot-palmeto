package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.spring.dao.EmpDaoJdbcImpl;
import com.demo.spring.dao.EmpDaoJpaImpl;

@Configuration
@ComponentScan(basePackages="com.demo.spring")
public class AppConfig {

	@Bean("empJdbc")
	public EmpDaoJdbcImpl jdbcBean() {
		return new EmpDaoJdbcImpl();
	}
	
	@Bean("empJpa")
	public EmpDaoJpaImpl jpaBean() {
		return new EmpDaoJpaImpl();
	}
	
}
