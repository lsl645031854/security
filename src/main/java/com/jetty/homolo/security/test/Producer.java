package com.jetty.homolo.security.test;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-23  上午9:30
 */
public class Producer {

	public static void main(String[] args) throws JMSException {
		//第一步：根据url创建一个jms Connection。
		String QUEUE = "first-queue";
		ActiveMQConnectionFactory connectionfactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = connectionfactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue(QUEUE);
		MessageProducer messageProducer = session.createProducer(queue);
		for (int i = 0; i < 3; i++) {
			Message message = session.createTextMessage(QUEUE + i);
			message.setStringProperty("k1", "v1");
			messageProducer.send(message);
		}
		System.out.println("生产消息成功...");
		session.close();
		connection.close();
	}
}
