package com.panshi.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panshi.user.domain.User;
import com.panshi.user.mapper.UserMapper;
import com.panshi.user.service.UserService;
@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserById(Integer userId) {
		return userMapper.getUserById(userId);
	}

	@Override
	public List<User> queryAll(Integer startIndex, Integer limit,String inputName) {
		return userMapper.queryAll(startIndex,limit, inputName);
	}

	@Override
	public Integer countAll(String inputName) {
		return userMapper.countAll( inputName);
	}

	@Override
	public void save(User user) {
		userMapper.save( user );
	}

	@Override
	public void deleteByIds(String ids) {
		userMapper.deleteByIds(ids);	
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
		
	}
	

}
