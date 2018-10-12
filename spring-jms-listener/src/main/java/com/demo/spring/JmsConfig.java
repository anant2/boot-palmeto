package com.demo.spring;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@ComponentScan(basePackages="com.demo.spring")
@EnableJms
public class JmsConfig {

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
		cf.setBrokerURL("tcp://localhost:61616");
		return cf;
	}
	
	@Bean
	public JmsListenerContainerFactory<?> factory(){
		DefaultJmsListenerContainerFactory cf = new DefaultJmsListenerContainerFactory();
		cf.setConnectionFactory(connectionFactory());
		cf.setPubSubDomain(true);
		return cf;
	}
	
	@Bean
	public JmsTemplate jt() {
		JmsTemplate jt = new JmsTemplate();
		jt.setConnectionFactory(connectionFactory());
		return jt;
	}
	
}
