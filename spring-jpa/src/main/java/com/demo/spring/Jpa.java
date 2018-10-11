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
		//hr.registerEmployee(new Emp(200,"Charan","Vizag",25000));
		//hr.getAll();
		hr.deleteById(203);

	}

}
