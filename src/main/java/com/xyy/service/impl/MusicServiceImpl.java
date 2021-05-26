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
    public Integer insertMusic(Music music) {
        this.musicMapper.insertSelective(music);
        return music.getM_id();
    }

    @Override
    public int deleteMusics(Integer[] mids) {
        for (Integer mid : mids){
            if(this.musicMapper.deleteByPrimaryKey(
                    mid
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
        return this.musicMapper.updateByExampleSelective(music,example);
    }

    @Override
    public List<Music> findMusicByMC(Integer cid, Integer sid, String mname) {
        MusicExample example = new MusicExample();
        MusicExample.Criteria criteria = example.createCriteria();
        if(cid!=null){
            criteria.andCa_idEqualTo(cid);
        }
        if(sid!=null){
            criteria.andS_idEqualTo(sid);
        }
        if(mname!=null){
            criteria.andM_nameLike('%'+mname+'%');
        }
        example.setOrderByClause("hot desc");
        return this.musicMapper.selectByExample(example);
    }

    @Override
    public List<Music> findMusicByMC(Integer cid) {
        MusicExample example = new MusicExample();
        MusicExample.Criteria criteria = example.createCriteria();
        if(cid!=null){
            criteria.andCa_idEqualTo(cid);
        }
        return this.musicMapper.selectByExample(example);
    }

    @Override
    public List<Music> findMusicPaiHang(Integer size) {
        MusicExample example = new MusicExample();
        String limitsize = String.valueOf(size);
        example.setOrderByClause("hot desc limit 0,"+limitsize);
        return this.musicMapper.selectByExample(example);
    }
}
