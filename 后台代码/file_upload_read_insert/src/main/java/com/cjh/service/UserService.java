package com.cjh.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjh.entity.User;
import com.cjh.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	public List<User> selectAll() throws Exception {
		return userMapper.selectAll();
	}

	public void insert(Set<User> users) throws Exception {
		for (User user : users) {
			userMapper.insert(user);
		}
	}
}
