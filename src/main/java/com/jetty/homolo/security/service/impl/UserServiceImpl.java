package com.jetty.homolo.security.service.impl;

import com.jetty.homolo.security.entity.User;
import com.jetty.homolo.security.mapper.UserMapper;
import com.jetty.homolo.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-16  下午12:41
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public User findUserById(int id) {
		String key = "user_" + id;
		ValueOperations<String, User> operations = redisTemplate.opsForValue();
		boolean hasKey = redisTemplate.hasKey(key);
		User user;
		if (hasKey) {
			user = operations.get(key);
			System.out.println("==========从缓存中获得数据=========");
			System.out.println(user.getUsername());
			System.out.println("==============================");
		} else {
			user = userMapper.findUserById(id);
			System.out.println("==========从数据表中获得数据=========");
			System.out.println(user.getUsername());
			System.out.println("==============================");

			// 写入缓存
			operations.set(key, user, 5, TimeUnit.MINUTES);
		}
		return user;
	}
}
