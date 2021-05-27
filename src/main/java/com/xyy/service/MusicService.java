package com.xyy.service;

import com.xyy.po.Music;

import java.util.HashMap;
import java.util.List;


public interface MusicService {
    List<HashMap<String,Object>> findMusic();

    Integer insertMusic(Music music);

    int deleteMusics(Integer[] mids);

    int updateMusic(Music music);

    int updateMusicHot(Integer mid);

    List<HashMap<String,Object>> findMusicByMC(Integer cid, Integer sid, String mname);

    List<Music> findMusicByMC(Integer cid);

    List<Music> findMusicPaiHang(Integer size);
}
