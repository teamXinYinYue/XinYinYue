package com.xyy.service.impl;

import java.util.List;

import com.xyy.dao.UserMapper;
import com.xyy.po.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyy.po.User;
import com.xyy.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int addUser(User user) {
		return this.userMapper.insert(user);
	}

	@Override
	public int deleteUser(Integer id) { return this.userMapper.deleteByPrimaryKey(id); }

	@Override
	public User findUser(String u_name, String pass_word) {

		UserExample example = new UserExample();
		example.createCriteria().andU_nameEqualTo(u_name).andPass_wordEqualTo(pass_word);
		List<User>list = this.userMapper.selectByExample(example);
		User user=null;
		for (User user0 : list) {
			user=user0;
		}
		return user;
	}

	@Override
	public User findUserByName(String u_name) {
		UserExample example = new UserExample();
		example.createCriteria().andU_nameEqualTo(u_name);
		List<User>list = this.userMapper.selectByExample(example);
		User user=null;
		for (User user0 : list) {
			user=user0;
		}
		return user;
	}

	@Override
	public List<User> findUser() {
		UserExample example = new UserExample();
		example.createCriteria().andPass_wordIsNotNull();
		return this.userMapper.selectByExample(example);
	}

}
