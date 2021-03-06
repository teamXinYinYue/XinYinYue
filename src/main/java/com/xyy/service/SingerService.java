package com.xyy.service;

import com.xyy.po.Singer;

import java.util.HashMap;
import java.util.List;


public interface SingerService {

    List<Singer> findSinger();

    List<Singer> findSingerByName(String sname);

    List<HashMap<String,Object>> findSingerAlsoBackimg();

    int findSingerIDByName(String s_name);

    List<HashMap<String,Object>> findSingerByNameAlsoBackimg(String s_name);

    List<Singer> findSingerBySid(Integer s_id);

    Integer insertSinger(Singer singer);

    int deleteSingers(Integer[] sids);

    int updateSinger(Singer singer);


}
