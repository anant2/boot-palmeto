package com.demo.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class Audience {
	
	@Pointcut("execution(* com.demo.spring.*.perform(..))")
	private void pcut() {
		
	}
	
	@Before("pcut()")
	public void switchOffMobile() {
		System.out.println("Switching off mobiles.........");
	}
	
	@Before("pcut()")
	public void takeSeat() {
		System.out.println("Audience taking seats.........");
	}
	
	@After("pcut()")
	public void takeCheck() {
		System.out.println("Audience checking.........");
	}
	
	@AfterReturning("pcut()")
	public void applaud() {
		System.out.println("Good Singing...Clap!Clap!!......");
	}

}
