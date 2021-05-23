package com.xyy.po;

public class Location {
    private Integer l_id;

    private Integer s_id;

    private String i_info;

    private String i_path;

    public Integer getL_id() {
        return l_id;
    }

    public void setL_id(Integer l_id) {
        this.l_id = l_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getI_info() {
        return i_info;
    }

    public void setI_info(String i_info) {
        this.i_info = i_info == null ? null : i_info.trim();
    }

    public String getI_path() {
        return i_path;
    }

    public void setI_path(String i_path) {
        this.i_path = i_path == null ? null : i_path.trim();
    }
}