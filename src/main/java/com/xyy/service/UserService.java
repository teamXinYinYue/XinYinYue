package com.xyy.service;

import java.util.List;

import com.xyy.po.UserExample;
import org.apache.ibatis.annotations.Param;

import com.xyy.po.User;

public interface UserService {


	int addUser(User user);

	int deleteUser(@Param("id") Integer id);

	User findUser(String u_name, String pass_word);

	User findUserByName(String u_name);

	List<User> findUser();
}


