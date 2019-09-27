package com.jetty.homolo.security.test;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.io.IOException;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-23  上午9:30
 */
public class Consumer {

	public static void main(String[] args) throws JMSException, IOException {
		//第一步：根据url创建一个jms Connection。
		String QUEUE = "first-queue";
		ActiveMQConnectionFactory connectionfactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = connectionfactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue(QUEUE);
		MessageConsumer messageConsumer = session.createConsumer(queue);
		messageConsumer.setMessageListener(message -> {
			if (null != message && (message instanceof TextMessage)) {
				try {
					TextMessage textMessage = (TextMessage) message;
					String k1 = textMessage.getStringProperty("k1");
					System.out.println("接收到的消息：" + textMessage.getText() + "属性值：" + k1);
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		System.in.read();
		session.close();
		connection.close();
	}
}
