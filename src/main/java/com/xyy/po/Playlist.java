package com.xyy.po;

public class Playlist {
    private String p_name;

    private Integer u_id;

    private String p_info;

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name == null ? null : p_name.trim();
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getP_info() {
        return p_info;
    }

    public void setP_info(String p_info) {
        this.p_info = p_info == null ? null : p_info.trim();
    }
}