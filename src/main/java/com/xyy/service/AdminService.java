package com.xyy.service;

import com.xyy.po.Admin;

import java.util.List;


public interface AdminService {
    Integer insertAdmin(Admin admin);
    Admin findAdmin(String u_name, String pass_word);
    List<Admin> findAdmin();

    Integer findAdminByNameEx(String admin_uname);
}
