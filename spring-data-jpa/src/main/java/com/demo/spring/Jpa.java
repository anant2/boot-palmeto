package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.entity.Emp;
import com.demo.spring.service.HrService;

public class Jpa {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		
		HrService hr = ctx.getBean(HrService.class);
		//hr.displayEmpInfo(101);
		//hr.registerEmployee(new Emp(201,"Charan","Delhi",45000));
		hr.getAll();
		//hr.deleteById(201);
		//hr.listWithSalaryRange(30000.0, 45000.0);

	}

}
