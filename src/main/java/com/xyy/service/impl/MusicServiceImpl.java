package com.xyy.service.impl;

import com.xyy.dao.MusicMapper;
import com.xyy.dao.SingerMapper;
import com.xyy.po.Music;
import com.xyy.po.MusicExample;
import com.xyy.po.Singer;
import com.xyy.po.SingerExample;
import com.xyy.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service("musicService")
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;

    @Autowired
    private SingerMapper singerMapper;

    @Override
    public List<HashMap<String,Object>> findMusic() {
        MusicExample example = new MusicExample();
        example.createCriteria().andM_idIsNotNull();
        List<Music> musicList = this.musicMapper.selectByExample(example);
        List<HashMap<String,Object>> list=new ArrayList();
        for (Music music:musicList) {
            SingerExample singerExample = new SingerExample();
            singerExample.createCriteria().andS_idEqualTo(music.getS_id());
            List<Singer> singerList = this.singerMapper.selectByExample(singerExample);
            HashMap map=new HashMap();
            for(Singer singer:singerList){
                map.put("m_id",music.getS_id());
                map.put("m_name",music.getM_name());
                map.put("priority",music.getPriority());
                map.put("mdate",music.getMdate());
                map.put("path",music.getPath());
                map.put("hot",music.getHot());
                map.put("s_id",singer.getS_id());
                map.put("s_name",singer.getS_name());
            }
            list.add(map);
        }
        return list;
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
    public int updateMusicHot(Integer mid) {
        MusicExample example = new MusicExample();
        example.createCriteria().andM_idEqualTo(mid);
        //TODO 本来可以自己写mapper 但是自动生成的文件老是需要手动添加代码，所以干脆不加自己的，以后再加，不加的话性能损失太大，等不再数据库设计时，加入自己的mapper代码
        Music music= this.musicMapper.selectByPrimaryKey(mid);
        music.setHot(music.getHot()+1);
        return this.musicMapper.updateByExampleSelective(music,example);
    }

    @Override
    public List<HashMap<String,Object>> findMusicByMC(Integer cid, Integer sid, String mname) {
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
        List<Music> musicList = this.musicMapper.selectByExample(example);
        List<HashMap<String,Object>> list= new ArrayList();
        for (Music music:musicList) {
            SingerExample singerExample = new SingerExample();
            singerExample.createCriteria().andS_idEqualTo(music.getS_id());
            List<Singer> singerList = this.singerMapper.selectByExample(singerExample);
            HashMap map=new HashMap();
            for(Singer singer:singerList){
                map.put("m_id",music.getS_id());
                map.put("m_name",music.getM_name());
                map.put("priority",music.getPriority());
                map.put("mdate",music.getMdate());
                map.put("path",music.getPath());
                map.put("hot",music.getHot());
                map.put("s_id",singer.getS_id());
                map.put("s_name",singer.getS_name());
            }
            list.add(map);
        }
        return list;
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
