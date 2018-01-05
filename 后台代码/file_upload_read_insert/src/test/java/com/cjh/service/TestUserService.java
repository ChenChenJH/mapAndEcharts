package com.cjh.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cjh.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestUserService{
	@Autowired
	private UserService userService;
	
	@Test
	public void testSelectAll() throws Exception{
		List<User> list = userService.selectAll();
		for(User user:list){
			System.out.println("学号："+user.getStuNo()+",姓名:"+user.getName());
		}
	}
	
	@Test
	public void testInsert() throws Exception{
		User user = new User();
		user.setStuNo("0104150401");
		user.setName("陈锋");
	}
}
