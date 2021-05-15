package com.xyy.web.controller;

import com.xyy.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
public class TestController {

//    @RequestMapping(value = "/index")
//    public String toIndex() {return "test-html/index";}

    @RequestMapping(value = "/skip")
    public String toSkip() {return "test-html/skip";}

    @RequestMapping(value = "/home")
    public String toTestHtml() {return "test-html/home";}

    @RequestMapping(value = "/toTestJson")
    public String toTestJson() {return "test/json";}

    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/toRegister")
    public String toAddUser() {return "register";}

    @RequestMapping(value = "/toTestJsonList")
    public String toTestJsonList() {return "playlist/plmusic";}

//    @Autowired
//    private UserService userService;
//
    //测试json
    @ResponseBody
    @RequestMapping(value = "/testJson")
    public HashMap testJson(String u_name,String pass_word) //@RequestBody User User
    {
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("u_name",u_name);
        hashMap.put("pass_word",pass_word);
        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/testJson2",method = RequestMethod.POST)
    public HashMap testJson() {
        HashMap<String,Object> hashMap=new HashMap<>();
        System.out.println(hashMap);
        User user1=new User();
        User user2=new User();
        List<User> list =new ArrayList<>();
        user1.setPriority(1);
        user2.setPriority(1);
        list.add(user1);
        list.add(user2);
        hashMap.put("list",list);
        hashMap.put("ok","ok");
        return hashMap;
    }

//
//
//
//    //测试分页
//    @RequestMapping(value = "/testPage")
//    public String testPage(Model model) {
//
//        //获取第2页，3条内容，默认查询总数count
//        PageHelper.startPage(-1, 3);
//
//        List<User> testPage = userService.findUserAll();
//
//        int count=0;
//        for (User user : testPage) {
//            count++;
//        }
//        System.out.println(count);
//        model.addAttribute("testPage", testPage);
//
//        return "test/page";
//    }

    //	@RequestMapping(value = "/login.action",method = RequestMethod.POST)
//	public String login(@Valid User target, BindingResult bindingResult,
//                        String u_name, String pass_word, Model model,
//						HttpSession session) {
//
//		//数据校验
//		if(bindingResult.getErrorCount()>0){
//			FieldError Error = bindingResult.getFieldError();
//			if(Error!=null){
//				model.addAttribute("msg",
//						Error.getDefaultMessage());
//			}
//			return "login";
//		}
//
//		User user=userService.findUser(u_name,pass_word);
//		if(user!=null) {
//
//			session.setAttribute("login_user", user);
//
//			return "redirect:userList.action";
//		}
//
//		model.addAttribute("msg", "密码或用户名错误，请重新登录");
//
//		return "login";
//
//	}
//
//
//	@RequestMapping(value = "/register.action",method = RequestMethod.POST)
//	public String addUser(@Valid User target, BindingResult bindingResult,
//                          String u_name, String pass_word, Model model,
//						  HttpSession session) {
//
//		//数据校验
//		if(bindingResult.getErrorCount()>0){
//			FieldError Error = bindingResult.getFieldError();
//			if(Error!=null){
//				model.addAttribute("msg",
//						Error.getDefaultMessage());
//			}
//			return "register";
//		}
//
//		User user=new User();
//		user.setU_name(u_name);
//		user.setPass_word(pass_word);
//
//		int rows=userService.addUser(user);
//
//		if(rows>0) {
//
//			session.setAttribute("login_user", user);
//
//			return "redirect:userList.action";
//
//		} else {
//
//			model.addAttribute("msg", "用户添加异常，请重试！");
//
//			return "register";
//
//		}
//
//	}
//    @RequestMapping(value = "/updateUser.action",method = RequestMethod.POST)
//    public String updateUser(@Valid User target, BindingResult bindingResult,
//                             String u_name, String pass_word, Integer u_id, RedirectAttributes redirectAttrs) {
//        //数据校验
//        if(bindingResult.getErrorCount()>0){
//            FieldError Error = bindingResult.getFieldError();
//            if(Error!=null){
//                redirectAttrs.addFlashAttribute("msg",
//                        Error.getDefaultMessage());
//            }
//            return "redirect:userList.action";
//        }
//
//        User user=new User();
//        user.setU_name(u_name);
//        user.setPass_word(pass_word);
//        user.setU_id(u_id);
//
//        int rows=userService.updateUser(user);
//
//        if(rows>0) {
//
//            redirectAttrs.addFlashAttribute("msg", "用户更新成功！");
//
//        } else {
//
//            redirectAttrs.addFlashAttribute("msg", "用户更新异常，请重试！");
//
//        }
//
//        return "redirect:userList.action";
//
//    }
//
//    @RequestMapping(value = "/deleteUser.action")
//    public String deleteUser(Integer u_id, RedirectAttributes redirectAttrs) {
//
//        int rows=userService.deleteUser(u_id);
//
//        if(rows>0) {
//
//            redirectAttrs.addFlashAttribute("msg", "用户删除成功！");
//
//
//        } else {
//
//            redirectAttrs.addFlashAttribute("msg", "用户删除异常，请重试！");
//
//        }
//
//        return "redirect:userList.action";
//
//    }
}
