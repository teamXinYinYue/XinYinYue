package com.xyy.controller;

import com.xyy.po.Admin;
import com.xyy.service.AdminService;
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
public class AdminController {

    @Autowired
    private AdminService adminService;


    @ResponseBody
    @RequestMapping(value = "/loginOneAdminByadmin",method = RequestMethod.POST)
    public HashMap loginOneUserByadmin(@Valid @RequestBody Admin admin, BindingResult bindingResult,
                                       HttpSession session) {
        HashMap hashMap=new HashMap();
        //数据校验
        if(bindingResult.getErrorCount()>0){
            FieldError Error = bindingResult.getFieldError();
            hashMap.put("error",Error.getDefaultMessage());
            hashMap.put("msg",false);
            return hashMap;
        }

        Admin adminResult=adminService.findAdmin(admin.getAdmin_uname(),admin.getAdmin_pass_word());
        if(adminResult!=null) {

            session.setAttribute("login_admin", adminResult);
            hashMap.put("msg",true);
            hashMap.put("login_admin",adminResult);
            return hashMap;
        }
        hashMap.put("msg",false);
        hashMap.put("error","密码或用户名错误，请重新登录");
        return hashMap;

    }

    @ResponseBody
    @RequestMapping(value = "/logOutAdminByNone",method = RequestMethod.POST)
    public HashMap logOutByNone(HttpSession session) {
        HashMap hashMap=new HashMap();
        session.removeAttribute("login_admin");
        hashMap.put("msg",true);
        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/registerOneAdminByadmin",method = RequestMethod.POST)
    public HashMap registerOneUserByuser(@Valid @RequestBody Admin admin, BindingResult bindingResult,
                                         HttpSession session) {
        HashMap hashMap=new HashMap();
        //数据校验
        if(bindingResult.getErrorCount()>0){
            FieldError Error = bindingResult.getFieldError();
            hashMap.put("error",Error.getDefaultMessage());
            hashMap.put("msg",false);
            return hashMap;
        }
        if(adminService.findAdminByNameEx(admin.getAdmin_uname())!=0) {
            hashMap.put("error","已有同名用户");
            hashMap.put("msg",false);
            return hashMap;
        }

        Admin adminResult=new Admin();
        adminResult.setAdmin_uname(admin.getAdmin_uname());
        adminResult.setAdmin_pass_word(admin.getAdmin_pass_word());

        Integer aid=adminService.insertAdmin(adminResult);
        adminResult.setAdmin_id(aid);
        if(aid!=null) {

            session.setAttribute("login_admin", adminResult);
            hashMap.put("msg",true);
            hashMap.put("login_admin",adminResult);
            return hashMap;

        } else {
            hashMap.put("error","用户添加异常，请重试！");
            hashMap.put("msg",false);
            return hashMap;

        }

    }


    @ResponseBody
    @RequestMapping(value = "/findManyAdminByNone" )
    public HashMap findManyAdminByNone() {

        HashMap hashMap=new HashMap();

        List<Admin> list=adminService.findAdmin();

        if( list.size()!=0) {
            hashMap.put("Adminlist",list);
            hashMap.put("msg",true);

            return hashMap;
        }
        hashMap.put("msg",false);

        return hashMap;
    }

}
