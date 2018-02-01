package com.offcn.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.UserMapper;
import com.offcn.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
        return userMapper.login(user);
	}

}
