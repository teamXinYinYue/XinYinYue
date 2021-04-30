package com.xyy.po;

public class Category {
    private Integer ca_id;

    private String ca_name;

    private String ca_info;

    private Integer l_id;

    public Integer getCa_id() {
        return ca_id;
    }

    public void setCa_id(Integer ca_id) {
        this.ca_id = ca_id;
    }

    public String getCa_name() {
        return ca_name;
    }

    public void setCa_name(String ca_name) {
        this.ca_name = ca_name == null ? null : ca_name.trim();
    }

    public String getCa_info() {
        return ca_info;
    }

    public void setCa_info(String ca_info) {
        this.ca_info = ca_info == null ? null : ca_info.trim();
    }

    public Integer getL_id() {
        return l_id;
    }

    public void setL_id(Integer l_id) {
        this.l_id = l_id;
    }
}