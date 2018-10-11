package com.demo.spring.app1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.spring.Mail;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
       Mail mail = (Mail) ctx.getBean("mail");
       Mail mail1 = (Mail) ctx.getBean("mail");
       System.out.println(mail.toString());
       System.out.println(mail1.toString());
       
       
       
       
       
    }
}
