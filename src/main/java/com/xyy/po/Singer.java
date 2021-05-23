package com.xyy.po;

public class Singer {
    private Integer s_id;

    private String s_name;

    private String s_info;

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name == null ? null : s_name.trim();
    }

    public String getS_info() {
        return s_info;
    }

    public void setS_info(String s_info) {
        this.s_info = s_info == null ? null : s_info.trim();
    }
}