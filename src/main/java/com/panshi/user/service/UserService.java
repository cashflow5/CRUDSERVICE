package com.panshi.user.service;

import java.util.List;

import com.panshi.user.domain.User;

public interface UserService {
	
	User getUserById(Integer userId);

	List<User> queryAll(Integer startIndex, Integer limit, String inputName);

	Integer countAll(String inputName);

	void save(User user);

	void deleteByIds(String ids);

	void update(User user);

}
