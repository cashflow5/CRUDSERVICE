package com.panshi.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panshi.user.domain.ResEntity;
import com.panshi.user.domain.User;
import com.panshi.user.mapper.UserMapper;
import com.panshi.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/{userId}")
	public User getUserById (@PathVariable Integer userId) {
		return userService.getUserById(userId);
	}
	
	@GetMapping("/users")
	public ResEntity queryAll ( @RequestParam Integer page,
								 @RequestParam Integer limit,
								  @RequestParam  String inputName ) throws Exception {
	
			Thread.sleep(10000);
		
		if( inputName==null ) {
			inputName = "";
		}
		Integer start = (page-1)*limit;
		List<User> list = userService.queryAll( start,limit,inputName);
		Integer count = userService.countAll(inputName);
		ResEntity res = new ResEntity();
		res.setCount( count );
		res.setCode(0);// js页面的特别要求，render table 必须传0
		res.setData(list);
		return res;
	}
	
//	@RequestMapping("/countAll")
//	public Integer countAll (String name) {
//		if( name==null ) {
//			name = "";
//		}
//		return userService.countAll(name);
//	}
//	
	@PostMapping("/user")
	public ResEntity addUser(@RequestBody User user) {
		ResEntity res = new ResEntity();
		try {
			userService.save(user);
			res.setCode(1);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			res.setCode(0);
		}
	
		return res;	
	}
	
	@DeleteMapping("/user/{ids}")
	public ResEntity delUsers(@PathVariable String ids) {
		ResEntity re = new ResEntity();
		try {
			userService.deleteByIds(ids);
			re.setCode(1);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			re.setCode(0);
		}
		return re;
	}
	
	@PutMapping("/user/{id}")
	public ResEntity updateUser( @PathVariable Integer id, @RequestBody User user) {
		ResEntity re = new ResEntity();	
		try {
			userService.update(user);
			re.setCode(1);
		} catch (Exception e) {
			e.printStackTrace();
			re.setCode(0);
		}
		
		return re;	
	}

}
