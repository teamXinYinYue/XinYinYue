package com.xyy.utils;


import java.util.List;

/**
 * @author user
 * @date 2021/4/13 - 23:00
 */
public class MyPageInfo<T> {
    private List<T> list;
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Object obj;

    public MyPageInfo() {
    }

    public MyPageInfo(List<T> list, Integer pageNum, Integer pageSize, Integer totalPage) {
        this.list = list;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
    }

    public MyPageInfo(List<T> list, Integer pageNum, Integer pageSize, Integer totalPage, Object obj) {
        this.list = list;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
