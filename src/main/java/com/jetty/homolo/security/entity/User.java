package com.jetty.homolo.security.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-09  下午6:22
 */
public class User implements Serializable {
	private static final long serialVersionUID = -697152504620713624L;
	private Integer id;
	private String username;
	private String password;
	private List<Shoe> shoes;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public List<Shoe> getShoes() {
        return shoes;
    }

    public void setShoes(List<Shoe> shoes) {
        this.shoes = shoes;
    }

    @Override
	public String toString() {
		return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
	}
}
