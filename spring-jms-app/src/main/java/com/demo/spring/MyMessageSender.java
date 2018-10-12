package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MyMessageSender {

	public static void main(String[] args) {
	/*	ApplicationContext ctx = new AnnotationConfigApplicationContext(JmsConfig.class);
		JmsTemplate jt = ctx.getBean(JmsTemplate.class);

		for (int i = 20; i < 100; i++) {
			final int count = i;
			jt.send("testQueue", new MessageCreator() {
				
				public Message createMessage(Session session) throws JMSException {
					TextMessage tm = session.createTextMessage();
					tm.setText("Text " + count);
					return tm;			}
			});

			System.out.println(count);
		}*/
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JmsConfig.class);
		JmsTemplate jt = (JmsTemplate) ctx.getBean("jtPubSub");

		for (int i = 1; i < 20; i++) {
			final int count = i;
			jt.send("demoTopic", new MessageCreator() {
				
				public Message createMessage(Session session) throws JMSException {
					TextMessage tm = session.createTextMessage();
					tm.setText("Text " + count);
					return tm;			}
			});

			System.out.println("Sent");
		}
		
	}
}
