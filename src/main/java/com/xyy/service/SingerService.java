package com.xyy.service;

import com.xyy.po.Singer;

import java.util.List;


public interface SingerService {
    List<Singer> findSinger();

    int findSingerIDByName(String s_name);

    List<Singer> findSingerByName(String s_name);

    List<Singer> findSingerBySid(Integer s_id);

    int insertSinger(Singer singer);

    int deleteSingers(Integer[] sids);

    int updateSinger(Singer singer);
}
