package com.xyy.service;

import com.xyy.po.Music;

import java.util.List;


public interface MusicService {
    List<Music> findMusic();

    int insertMusic(Music music);


    int deleteMusics(List<Music> musics);

    int updateMusic(Music music);

    List<Music> findMusicByName(String m_name);

    List<Music> findMusicBySid(Integer s_id);
}
