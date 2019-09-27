package com.jetty.homolo.security.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-20  下午3:27
 */
@Component
public class Producer {

	@Autowired
	private JmsMessagingTemplate template;

	public void sendMessage(Queue queue, String content) {
		template.convertAndSend(queue, content);
	}
}
