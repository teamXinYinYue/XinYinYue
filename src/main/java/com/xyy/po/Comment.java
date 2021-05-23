package com.xyy.po;

import java.util.Date;

public class Comment {
    private Integer id;

    private Integer m_id;

    private String co_info;

    private Date co_date;

    private Integer u_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getCo_info() {
        return co_info;
    }

    public void setCo_info(String co_info) {
        this.co_info = co_info == null ? null : co_info.trim();
    }

    public Date getCo_date() {
        return co_date;
    }

    public void setCo_date(Date co_date) {
        this.co_date = co_date;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }
}