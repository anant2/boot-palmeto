package com.demo.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class AudienceAround {
	
	@Pointcut("execution(* com.demo.spring.*.perform(..))")
	private void pcut() {
		
	}
	
	
	public void buyTickets() {
		System.out.println("Audience purchased tickets.........");
	}
	
	
	public void exit() {
		System.out.println("Show over: Audience left the venue.........");
	}
	
	
	
	@Around("pcut()")
	public void invoke(ProceedingJoinPoint pjp) throws Throwable{
		buyTickets();
		pjp.proceed();
		exit();
	}
	
}
