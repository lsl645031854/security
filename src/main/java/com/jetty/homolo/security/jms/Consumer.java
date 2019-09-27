package com.jetty.homolo.security.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-20  下午3:47
 */
@Component
public class Consumer {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@JmsListener(destination = "ActiveMQQueue",containerFactory = "jmsListenerContainerQueue")
	public void receiveQueue(String text) {
		logger.info("消息消費者收到的报文为:"+text);
	}
}
