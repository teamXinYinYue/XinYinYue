package com.xyy.service;

import com.xyy.po.Plmusic;

import java.util.List;


public interface PlmusicService {
    int insertPlmusic(List<Plmusic> plmusics);
    int deletePlmusic(List<Plmusic> plmusics);
    List<Plmusic> findPlmusic(Integer u_id,String p_name);
}
