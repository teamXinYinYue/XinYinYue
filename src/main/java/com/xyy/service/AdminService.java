package com.xyy.service;

import com.xyy.po.Admin;

import java.util.List;

/**
 * @author user
 * @date 2021/6/10 - 9:09
 */
public interface AdminService {
    Integer insertAdmin(Admin admin);
    Admin findAdmin(String u_name, String pass_word);
    List<Admin> findAdmin();

    Integer findAdminByNameEx(String admin_uname);
}
