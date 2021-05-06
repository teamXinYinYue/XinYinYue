package com.xyy.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyy.po.Singer;
import com.xyy.po.User;
import com.xyy.service.UserService;
import com.xyy.utils.JsonInfo;
import com.xyy.utils.MyPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

	@Autowired
	private UserService userService;


	@ResponseBody
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public JsonInfo login(@Valid @RequestBody User user, BindingResult bindingResult,
						  HttpSession session) {
		JsonInfo jsonInfo=new JsonInfo();
		//数据校验
		if(bindingResult.getErrorCount()>0){
			FieldError Error = bindingResult.getFieldError();
			jsonInfo.setMsg(Error.getDefaultMessage());
			return jsonInfo;
		}

		User userResult=userService.findUser(user.getU_name(),user.getPass_word());
		if(userResult!=null) {

			session.setAttribute("login_user", userResult);
			jsonInfo.setMsg("登录成功");
			jsonInfo.setObj(userResult);
			return jsonInfo;
		}
		jsonInfo.setMsg( "密码或用户名错误，请重新登录");
		return jsonInfo;

	}

	@ResponseBody
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public JsonInfo addUser(@Valid @RequestBody  User user, BindingResult bindingResult,
							HttpSession session) {
		JsonInfo jsonInfo=new JsonInfo();
		//数据校验
		if(bindingResult.getErrorCount()>0){
			FieldError Error = bindingResult.getFieldError();
			jsonInfo.setMsg(Error.getDefaultMessage());
			return jsonInfo;
		}
		if(userService.findUserByName(user.getU_name())!=null) {
			jsonInfo.setMsg("已有同名用户");
			return jsonInfo;
		}

		User userResult=new User();
		userResult.setU_name(user.getU_name());
		userResult.setPass_word(user.getPass_word());

		int rows=userService.addUser(userResult);

		if(rows>0) {

			session.setAttribute("login_user", userResult);
			jsonInfo.setMsg("用户注册成功");
			jsonInfo.setObj(userResult);
			return jsonInfo;

		} else {
			jsonInfo.setMsg("用户添加异常，请重试！");
			return jsonInfo;

		}

	}

	@ResponseBody
	@RequestMapping(value = "/deleteUser")
	public JsonInfo deleteUser(Integer u_id) {
		JsonInfo jsonInfo=new JsonInfo();
		int rows=userService.deleteUser(u_id);

		if(rows>0) {

			jsonInfo.setMsg("用户删除成功！");

		} else {

			jsonInfo.setMsg("用户删除异常，请重试！");

		}
		return jsonInfo;

	}

	@ResponseBody
	@RequestMapping(value = "/userPage")
	public MyPageInfo<User> userPage(String uname,Integer pageNum,Integer pageSize) {
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

		MyPageInfo<User> mypage=new MyPageInfo<>(list,pageNum,pageSize,totalPage);
		return mypage;

	}

}
