package com.cjh.mapper;

import java.util.List;

import com.cjh.entity.User;

public interface UserMapper {
	public List<User> selectAll() throws Exception;
	
	public void insert(User user) throws Exception;
}
