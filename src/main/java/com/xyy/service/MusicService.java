package com.xyy.service;

import com.xyy.po.Music;

import java.util.List;


public interface MusicService {
    List<Music> findMusic();

    Integer insertMusic(Music music);

    int deleteMusics(Integer[] mids);

    int updateMusic(Music music);

    List<Music> findMusicByMC(Integer cid, Integer sid, String mname);

    List<Music> findMusicByMC(Integer cid);

    List<Music> findMusicPaiHang(Integer size);
}
