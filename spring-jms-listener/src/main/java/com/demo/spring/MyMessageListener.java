package com.demo.spring;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MyMessageListener {

	@JmsListener(destination="demoTopic",containerFactory="factory")
	public void receive(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			System.out.println(tm.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
