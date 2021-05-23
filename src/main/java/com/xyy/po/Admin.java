package com.xyy.po;

public class Admin {
    private Integer admin_id;

    private String admin_uname;

    private String admin_pass_word;

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_uname() {
        return admin_uname;
    }

    public void setAdmin_uname(String admin_uname) {
        this.admin_uname = admin_uname == null ? null : admin_uname.trim();
    }

    public String getAdmin_pass_word() {
        return admin_pass_word;
    }

    public void setAdmin_pass_word(String admin_pass_word) {
        this.admin_pass_word = admin_pass_word == null ? null : admin_pass_word.trim();
    }
}