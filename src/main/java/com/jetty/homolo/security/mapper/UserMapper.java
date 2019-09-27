package com.jetty.homolo.security.mapper;

import com.jetty.homolo.security.entity.User;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-09  下午7:02
 */
public interface UserMapper {
	int insertUser(User user);
	User findUserById (int id);
}
