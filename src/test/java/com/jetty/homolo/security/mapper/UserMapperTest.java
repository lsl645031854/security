package com.jetty.homolo.security.mapper;

import com.jetty.homolo.security.entity.User;
import com.jetty.homolo.security.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-09  下午7:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private IUserService userService;

	@Test
	public void testInsert() {
		userMapper.insertUser(new User("admin", "admin"));
	}
	@Test
	public void testGetOne() {
		User userById = userService.findUserById(1);
//		User userById = userMapper.findUserById(1);
		logger.info("用户信息为:{}", userById);
	}
}
