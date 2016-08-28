package com.faunjoe.springmybatis.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.faunjoe.springmybatis.domain.User;
import com.faunjoe.springmybatis.mapper.UserMapper;



@RunWith(SpringJUnit4ClassRunner.class) //ʹ��Springtest���Կ��
@ContextConfiguration("/beans.xml") //��������

public class SMTest {
	
	@Autowired  //ע��
	private UserMapper userMapper;
	
	@Test
	public void save() {
		User user = new User();
		user.setBirthday(new Date());
		user.setName("marry");
		user.setSalary(300);
		userMapper.save(user);
		System.out.println(user.getId());
	}

	@Test
	public void update() {
		User user = userMapper.findById(2);
		user.setSalary(2000);
		userMapper.update(user);
	}

	@Test
	public void delete() {
		userMapper.delete(3);
	}

	@Test
	public void findById() {
		User user = userMapper.findById(1);
		System.out.println(user);
	}

	@Test
	public void findAll() {
		List<User> users = userMapper.findAll();
		System.out.println(users);
	}

}
