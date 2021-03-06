package com.xyy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyy.po.Playlist;
import com.xyy.po.User;
import com.xyy.service.PlaylistService;
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
	@Autowired
	private PlaylistService playlistService;

	@ResponseBody
	@RequestMapping(value = "/loginOneUserByuser",method = RequestMethod.POST)
	public HashMap loginOneUserByuser(@Valid @RequestBody User user, BindingResult bindingResult,
                                      HttpSession session) {
		HashMap hashMap=new HashMap();
		//数据校验
		if(bindingResult.getErrorCount()>0){
			FieldError Error = bindingResult.getFieldError();
			hashMap.put("error",Error.getDefaultMessage());
			hashMap.put("msg",false);
			return hashMap;
		}

		User userResult=userService.findUser(user.getU_name(),user.getPass_word());
		if(userResult!=null) {

			session.setAttribute("login_user", userResult);
			hashMap.put("msg",true);
			hashMap.put("login_user",userResult);
			return hashMap;
		}
		hashMap.put("msg",false);
		hashMap.put("error","密码或用户名错误，请重新登录");
		return hashMap;

	}

	@ResponseBody
	@RequestMapping(value = "/logOutByNone",method = RequestMethod.POST)
	public HashMap logOutByNone(HttpSession session) {
		HashMap hashMap=new HashMap();
		session.removeAttribute("login_user");
		hashMap.put("msg",true);
		return hashMap;
	}

	@ResponseBody
	@RequestMapping(value = "/registerOneUserByuser",method = RequestMethod.POST)
	public HashMap registerOneUserByuser(@Valid @RequestBody User user, BindingResult bindingResult,
                                         HttpSession session) {
		HashMap hashMap=new HashMap();
		//数据校验
		if(bindingResult.getErrorCount()>0){
			FieldError Error = bindingResult.getFieldError();
			hashMap.put("error",Error.getDefaultMessage());
			hashMap.put("msg",false);
			return hashMap;
		}
		if(userService.findUserByNameEx(user.getU_name())!=0) {
			hashMap.put("error","已有同名用户");
			hashMap.put("msg",false);
			return hashMap;
		}

		User userResult=new User();
		userResult.setU_name(user.getU_name());
		userResult.setPass_word(user.getPass_word());
		userResult.setR_id(1);
		userResult.setScore(0);
		userResult.setSex(user.getSex());
		userResult.setSign_info(user.getSign_info());
		Integer uid=userService.insertUser(userResult);
		userResult.setU_id(uid);

		if(uid!=null) {

			Playlist playlist = new Playlist();
			playlist.setP_name("我喜欢的音乐");
			playlist.setP_info("默认歌单");
			playlist.setU_id(uid);
			playlistService.insertPlaylist(playlist);

			session.setAttribute("login_user", userResult);
			hashMap.put("msg",true);
			hashMap.put("login_user",userResult);
			return hashMap;

		} else {
			hashMap.put("error","用户添加异常，请重试！");
			hashMap.put("msg",false);
			return hashMap;

		}

	}

	@ResponseBody
	@RequestMapping(value = "/deleteOneUserByuid",method = RequestMethod.POST)
	public HashMap deleteOneUserByuid(Integer u_id) {
		HashMap hashMap=new HashMap();
		int rows=userService.deleteUser(u_id);

		if(rows>0) {

			hashMap.put("msg",true);

		} else {
			hashMap.put("msg",false);


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
