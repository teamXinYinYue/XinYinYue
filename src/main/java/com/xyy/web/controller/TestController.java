package com.xyy.web.controller;

import com.xyy.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author user
 * @date 2021/4/11 - 14:26
 */
@Controller
public class TestController {

    @RequestMapping(value = "/index")
    public String toIndex() {return "index";}

    @RequestMapping(value = "/skip")
    public String toSkip() {return "skip";}

    @RequestMapping(value = "/home")
    public String toTestHtml() {return "home";}

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
    @RequestMapping(value = "/testJson",method = RequestMethod.POST)
    public String testJson(@RequestBody User user) {
        System.out.println(user.getU_name());
        return "ok";
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
