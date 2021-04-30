package com.xyy.service.impl;

import com.xyy.dao.SingerMapper;
import com.xyy.po.Singer;
import com.xyy.po.SingerExample;
import com.xyy.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("singerService")
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerMapper singerMapper;

    @Override
    public List<Singer> findSinger() {
        SingerExample example = new SingerExample();
        example.createCriteria().andS_idIsNotNull();
        return this.singerMapper.selectByExample(example);
    }

    @Override
    public List<Singer> findSingerByName(String s_name) {
        SingerExample example = new SingerExample();
        example.createCriteria().andS_nameLike(s_name);
        return this.singerMapper.selectByExample(example);
    }

    @Override
    public List<Singer> findSingerBySid(Integer s_id) {
        SingerExample example = new SingerExample();
        example.createCriteria().andS_idEqualTo(s_id);
        return this.singerMapper.selectByExample(example);
    }

    @Override
    public int insertSinger(Singer singer) {
        return this.singerMapper.insert(singer);
    }

    @Override
    public int deleteSingers(List<Singer> singers) {
        for (Singer singer : singers){
            if(this.singerMapper.deleteByPrimaryKey(
                    singer.getS_id()
            )==0){
                throw new RuntimeException("未删除成功");
            }
        }
        return 1;
    }

    @Override
    public int updateSinger(Singer singer) {
        SingerExample example = new SingerExample();
        example.createCriteria().andS_idEqualTo(singer.getS_id());
        return this.singerMapper.updateByExample(singer,example);
    }
}
