package com.jetty.homolo.security.service;

import com.jetty.homolo.security.entity.User;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-16  下午12:40
 */
public interface IUserService {
	User findUserById (int id);
}
