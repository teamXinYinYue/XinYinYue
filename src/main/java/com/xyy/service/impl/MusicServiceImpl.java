package com.xyy.service.impl;

import com.xyy.dao.MusicMapper;
import com.xyy.po.Music;
import com.xyy.po.MusicExample;
import com.xyy.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("musicService")
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;

    @Override
    public List<Music> findMusic() {
        MusicExample example = new MusicExample();
        example.createCriteria().andM_idIsNotNull();
        return this.musicMapper.selectByExample(example);
    }

    @Override
    public List<Music> findMusicByName(String m_name) {
        MusicExample example = new MusicExample();
        example.createCriteria().andM_nameLike(m_name);
        return this.musicMapper.selectByExample(example);
    }

    @Override
    public List<Music> findMusicBySid(Integer s_id) {
        MusicExample example = new MusicExample();
        example.createCriteria().andS_idEqualTo(s_id);
        return this.musicMapper.selectByExample(example);
    }

    @Override
    public int insertMusic(Music music) {
        return this.musicMapper.insert(music);
    }

    @Override
    public int deleteMusics(List<Music> musics) {
        for (Music music : musics){
            if(this.musicMapper.deleteByPrimaryKey(
                    music.getM_id()
            )==0){
                throw new RuntimeException("未删除成功");
            }
        }
        return 1;
    }

    @Override
    public int updateMusic(Music music) {
        MusicExample example = new MusicExample();
        example.createCriteria().andM_idEqualTo(music.getM_id());
        return this.musicMapper.updateByExample(music,example);
    }


}
