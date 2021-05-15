package com.xyy.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyy.po.User;
import com.xyy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

	@Autowired
	private UserService userService;


	@ResponseBody
	@RequestMapping(value = "/loginOneUserByuser",method = RequestMethod.POST)
	public HashMap loginOneUserByuser(@Valid @RequestBody User user, BindingResult bindingResult,
						  HttpSession session) {
		HashMap hashMap=new HashMap();
		//数据校验
		if(bindingResult.getErrorCount()>0){
			FieldError Error = bindingResult.getFieldError();
			hashMap.put("msg",Error.getDefaultMessage());
			return hashMap;
		}

		User userResult=userService.findUser(user.getU_name(),user.getPass_word());
		if(userResult!=null) {

			session.setAttribute("login_user", userResult);
			hashMap.put("msg","登录成功");
			hashMap.put("login_user",userResult);
			return hashMap;
		}
		hashMap.put("msg","密码或用户名错误，请重新登录");
		return hashMap;

	}

	@ResponseBody
	@RequestMapping(value = "/registerOneUserByuser",method = RequestMethod.POST)
	public HashMap registerOneUserByuser(@Valid @RequestBody  User user, BindingResult bindingResult,
							HttpSession session) {
		HashMap hashMap=new HashMap();
		//数据校验
		if(bindingResult.getErrorCount()>0){
			FieldError Error = bindingResult.getFieldError();
			hashMap.put("msg",Error.getDefaultMessage());
			return hashMap;
		}
		if(userService.findUserByName(user.getU_name())!=null) {
			hashMap.put("msg","已有同名用户");
			return hashMap;
		}

		User userResult=new User();
		userResult.setU_name(user.getU_name());
		userResult.setPass_word(user.getPass_word());
		userResult.setPriority(1);
		userResult.setR_id(user.getR_id());
		userResult.setScore(0);
		userResult.setSex(user.getSex());
		userResult.setSign_info(user.getSign_info());
		Integer uid=userService.insertUser(userResult);
		userResult.setU_id(uid);
		if(uid!=null) {

			session.setAttribute("login_user", userResult);
			hashMap.put("msg","用户注册成功");
			hashMap.put("login_user",userResult);
			return hashMap;

		} else {
			hashMap.put("msg","用户添加异常，请重试！");
			return hashMap;

		}

	}

	@ResponseBody
	@RequestMapping(value = "/deleteOneUserByuid",method = RequestMethod.POST)
	public HashMap deleteOneUserByuid(Integer u_id) {
		HashMap hashMap=new HashMap();
		int rows=userService.deleteUser(u_id);

		if(rows>0) {

			hashMap.put("msg","用户删除成功！");

		} else {

			hashMap.put("msg","用户删除异常，请重试！");

		}
		return hashMap;

	}

	@ResponseBody
	@RequestMapping(value = "/pageManyUserByuname")
	public HashMap pageManyUserByuname(String uname,Integer pageNum,Integer pageSize) {
		if(pageNum==null){
			pageNum=1;
		}else if(pageNum<1){
			pageNum=1;
		}

		if(pageSize==null){
			pageSize=3;
		}

		PageHelper.startPage(pageNum, pageSize);
		List<User> list =null;
		if(uname!=null){
			list =userService.findUserByName(uname);
		}else{
			list =userService.findUser();
		}

		PageInfo<User> info = new PageInfo(list);
		int totalPage=info.getPages();

		HashMap hashMap=new HashMap();
		hashMap.put("pageuserlist",list);
		hashMap.put("pageNum",pageNum);
		hashMap.put("pageSize",pageSize);
		hashMap.put("totalPage",totalPage);
		return hashMap;

	}

}
