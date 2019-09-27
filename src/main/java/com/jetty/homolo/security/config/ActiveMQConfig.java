package com.jetty.homolo.security.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-20  下午2:49
 */
@Configuration
public class ActiveMQConfig {

	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;

	@Value("${spring.activemq.user}")
	private String brokerUser;

	@Value("${spring.activemq.password}")
	private String brokerPassword;

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("ActiveMQQueue");
	}

	@Bean
	public Topic topic() {
		return new ActiveMQTopic("ActiveMQQueue");
	}

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory(brokerUser, brokerPassword, brokerUrl);
	}

	//Queue模式连接注入
	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory){
		DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
		bean.setConnectionFactory(connectionFactory);
		return bean;
	}

	//Topic模式连接注入
	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory connectionFactory){
		DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
		//设置为发布订阅方式, 默认情况下使用的生产消费者方式
		bean.setPubSubDomain(true);
		bean.setConnectionFactory(connectionFactory);
		return bean;
	}

}
