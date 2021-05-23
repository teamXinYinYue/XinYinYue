package com.xyy.po;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class User {
    private Integer u_id;

    private Integer r_id;

    @NotEmpty(message = "账号不能为空")
    private String u_name;
    @NotEmpty(message = "密码不能为空")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{6,20}$",message = "密码格式不正确强密码,必须包含大小写字母和数字的组合，不能使用特殊字符，长度在 6-20 之间")
    private String pass_word;

    private Integer score;

    private String sign_info;

    private String sex;

    private Integer priority;

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name == null ? null : u_name.trim();
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word == null ? null : pass_word.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getSign_info() {
        return sign_info;
    }

    public void setSign_info(String sign_info) {
        this.sign_info = sign_info == null ? null : sign_info.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}