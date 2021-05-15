package com.xyy.service;

import com.xyy.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {


	Integer insertUser(User user);

	int deleteUser(@Param("id") Integer id);

	User findUser(String u_name, String pass_word);

	List<User> findUserByName(String u_name);

	List<User> findUser();
}


