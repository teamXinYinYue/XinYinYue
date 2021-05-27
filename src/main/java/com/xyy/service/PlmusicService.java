package com.xyy.service;

import com.xyy.po.Plmusic;

import java.util.List;


public interface PlmusicService {
    int insertPlmusic(Integer[] mids,String pname,Integer uid);
    int deletePlmusic(Integer[] mids,String pname,Integer uid);
    List<Plmusic> findPlmusic(Integer u_id, String p_name);
}
