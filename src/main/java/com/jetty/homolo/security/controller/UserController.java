package com.jetty.homolo.security.controller;

import com.jetty.homolo.security.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-09  下午6:21
 */
@RestController
@RequestMapping("/user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@PostMapping
	public String createUser(User user) {
		logger.info("username:{}", user.getUsername());
		logger.info("username:{}", user.getShoes());
		return "111";
	}
}
