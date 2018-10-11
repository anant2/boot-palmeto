package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
		Performer p = (Performer) ctx.getBean("singer");
		p.perform();
		
		System.out.println(p.getClass().getName());
		
		/*Class<?> [] infs = p.getClass().getInterfaces(); 
		
		for(Class<?> c: infs)
		System.out.println(c.getName());*/
		
	}

}
