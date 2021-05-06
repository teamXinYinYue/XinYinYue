package com.xyy.service;

import com.xyy.po.Music;

import java.util.List;


public interface MusicService {
    List<Music> findMusic();

    int insertMusic(Music music);


    int deleteMusics(Integer[] mids);

    int updateMusic(Music music);

    List<Music> findMusicByMC(Integer cid,Integer sid,String mname);

    List<Music> findMusicPaiHang(Integer size);
}
