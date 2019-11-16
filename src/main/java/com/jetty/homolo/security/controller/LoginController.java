package com.jetty.homolo.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jetty.homolo.security.entity.User;
import com.jetty.homolo.security.jms.Producer;
import com.jetty.homolo.security.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private Producer producer;

	@Autowired
	private Queue queue;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private ObjectMapper objectMapper;

	@GetMapping("/register")
	public String register(String username, String password) throws Exception {
		logger.info("进入登录控制器……");
		User user = userMapper.findUserById(1);
		String userJson = objectMapper.writeValueAsString(user);
		producer.sendMessage(queue, userJson);
		return "register success";
	}
}
