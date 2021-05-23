package com.xyy.po;

public class Role {
    private Integer r_id;

    private String roletype;

    private Integer priority;

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getRoletype() {
        return roletype;
    }

    public void setRoletype(String roletype) {
        this.roletype = roletype == null ? null : roletype.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}