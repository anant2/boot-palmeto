package com.demo.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.entity.Emp;
import com.demo.spring.service.HrService;

public class JdbcMain2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		HrService hs = ctx.getBean(HrService.class);
		//hs.registerEmployee(new Emp(213, "Tanmoy", "Hyderabad", 20000));
		//hs.getAll();
		//hs.displayEmpInfo(119);
		hs.deleteById(103);
		

	}

}
