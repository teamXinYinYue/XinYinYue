package com.xyy.po;

public class Music {
    private Integer m_id;

    private String m_name;

    private Integer ca_id;

    private Integer s_id;

    private Integer priority;

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name == null ? null : m_name.trim();
    }

    public Integer getCa_id() {
        return ca_id;
    }

    public void setCa_id(Integer ca_id) {
        this.ca_id = ca_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}