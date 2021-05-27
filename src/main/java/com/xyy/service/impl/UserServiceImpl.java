package com.xyy.service.impl;

import com.xyy.dao.UserMapper;
import com.xyy.po.User;
import com.xyy.po.UserExample;
import com.xyy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public Integer insertUser(User user) {
		this.userMapper.insertSelective(user);
		return user.getU_id();
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
	public List<User> findUserByName(String u_name) {
		UserExample example = new UserExample();
		example.createCriteria().andU_nameLike('%'+u_name+'%');
		List<User> userList = this.userMapper.selectByExample(example);
		return userList;
	}

	@Override
	public Integer findUserByNameEx(String u_name) {
		UserExample example = new UserExample();
		example.createCriteria().andU_nameEqualTo(u_name);
		List<User> userList = this.userMapper.selectByExample(example);
		for (User user:userList) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<User> findUser() {
		UserExample example = new UserExample();
		example.createCriteria().andPass_wordIsNotNull();
		return this.userMapper.selectByExample(example);
	}

}
