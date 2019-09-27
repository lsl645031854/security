package com.jetty.homolo.security.controller;

import com.jetty.homolo.security.jms.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-20  下午2:29
 */
@RestController
public class LoginController {

	@Autowired
	private Producer producer;

	@Autowired
	private Queue queue;

	@GetMapping("/register")
	public String register(String username, String mobile) {
		producer.sendMessage(queue, username);
		return "register success";
	}
}
