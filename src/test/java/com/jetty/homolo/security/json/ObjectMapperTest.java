package com.jetty.homolo.security.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jetty.homolo.security.entity.User;
import com.jetty.homolo.security.utils.ObjectUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Author homolo
 * @DESC 优化.
 * @Create 2019-09-27  上午10:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectMapperTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void test() throws IOException {
		User user = new User("admin", "admin");
		user.setId(1);
		String string = mapper.writeValueAsString(user);
		logger.info(string);
		User format = mapper.readValue(string, User.class);
		logger.info(format.toString());
	}

	@Test
	public void test1() throws Exception {
		User user = new User("root", "root");
		user.setId(2);

		Class<? extends User> userClass = user.getClass();
		Method getUsername = userClass.getMethod("getUsername");
		Object invoke = getUsername.invoke(user);
		System.out.println(invoke.toString());
	}

	@Test
	public void test2() {
		User user = new User("root", "root");
		user.setId(2);
		Integer id = ObjectUtil.getFieldValueByName("id", user, Integer.class);
		logger.info("字段的值是：{}", id);
	}

	@Test
	public void test3() throws Exception {
		User user = new User("root", "root");
		user.setId(2);
		String string = ObjectUtil.writeValueAsString(user);
		logger.info("对象转json：{}", string);
	}
}
