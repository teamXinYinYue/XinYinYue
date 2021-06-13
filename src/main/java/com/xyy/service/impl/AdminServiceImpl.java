package com.xyy.service.impl;

import com.xyy.dao.AdminMapper;
import com.xyy.po.Admin;
import com.xyy.po.AdminExample;
import com.xyy.po.User;
import com.xyy.po.UserExample;
import com.xyy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Integer insertAdmin(Admin admin) {
        this.adminMapper.insertSelective(admin);
        return admin.getAdmin_id();
    }

    @Override
    public Admin findAdmin(String u_name, String pass_word) {

        AdminExample example = new AdminExample();
        example.createCriteria().andAdmin_unameEqualTo(u_name).andAdmin_pass_wordEqualTo(pass_word);
        List<Admin>list = this.adminMapper.selectByExample(example);
        Admin admin=null;
        for (Admin admin0 : list) {
            admin=admin0;
        }
        return admin;
    }


    @Override
    public List<Admin> findAdmin() {

        AdminExample example = new AdminExample();
        example.createCriteria().andAdmin_pass_wordIsNotNull();
        return this.adminMapper.selectByExample(example);
    }

    @Override
    public Integer findAdminByNameEx(String admin_uname) {
        AdminExample example = new AdminExample();
        example.createCriteria().andAdmin_unameEqualTo(admin_uname);
        List<Admin> list = this.adminMapper.selectByExample(example);
        for (Admin admin:list) {
            return 1;
        }
        return 0;
    }
}
