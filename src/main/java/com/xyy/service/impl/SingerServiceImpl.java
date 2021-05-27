package com.xyy.service.impl;

import com.xyy.dao.LocationMapper;
import com.xyy.dao.SingerMapper;
import com.xyy.po.Location;
import com.xyy.po.LocationExample;
import com.xyy.po.Singer;
import com.xyy.po.SingerExample;
import com.xyy.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service("singerService")
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerMapper singerMapper;
    @Autowired
    private LocationMapper locationMapper;

    @Override
    public List<Singer> findSinger() {
        SingerExample example = new SingerExample();
        example.createCriteria().andS_idIsNotNull();
        return this.singerMapper.selectByExample(example);
    }

    @Override
    public List<Singer> findSingerByName(String sname) {
        SingerExample example = new SingerExample();
        example.createCriteria().andS_nameLike(sname);
        return this.singerMapper.selectByExample(example);
    }

    @Override
    public List<HashMap<String,Object>> findSingerAlsoBackimg() {
        SingerExample example = new SingerExample();
        example.createCriteria().andS_idIsNotNull();
        List<Singer> singerList = this.singerMapper.selectByExample(example);
        List<HashMap<String,Object>> list=new ArrayList();
        for (Singer singer:singerList) {
            HashMap map=new HashMap();
            map.put("s_id",singer.getS_id());
            map.put("s_name",singer.getS_name());
            map.put("s_info",singer.getS_info());
            LocationExample locationExample = new LocationExample();
            locationExample.createCriteria().andS_idEqualTo(singer.getS_id());
            locationExample.setOrderByClause("l_id desc limit 0,1");
            List<Location> locations = this.locationMapper.selectByExample(locationExample);
            for(Location location:locations){
                map.put("l_id",location.getL_id());
                map.put("i_path",location.getI_path());
                map.put("i_info",location.getI_info());
            }
            list.add(map);
        }
        return list;
    }

    @Override
    public int findSingerIDByName(String s_name) {
        SingerExample example = new SingerExample();
        example.createCriteria().andS_nameLike('%'+s_name+'%');
        List<Singer> singerList= this.singerMapper.selectByExample(example);
        for(Singer singer:singerList){
            return singer.getS_id();
        }
        return 0;
    }

    @Override
    public List<HashMap<String,Object>> findSingerByNameAlsoBackimg(String s_name) {
        SingerExample example = new SingerExample();
        example.createCriteria().andS_nameLike(s_name);
        List<Singer> singerList = this.singerMapper.selectByExample(example);
        List<HashMap<String,Object>> list=new ArrayList();
        for (Singer singer:singerList) {
            HashMap map=new HashMap();
            map.put("s_id",singer.getS_id());
            map.put("s_name",singer.getS_name());
            map.put("s_info",singer.getS_info());
            LocationExample locationExample = new LocationExample();
            locationExample.createCriteria().andS_idEqualTo(singer.getS_id());
            locationExample.setOrderByClause("l_id desc limit 0,1");
            List<Location> locations = this.locationMapper.selectByExample(locationExample);
            for(Location location:locations){
                map.put("l_id",location.getL_id());
                map.put("i_path",location.getI_path());
                map.put("i_info",location.getI_info());
            }
            list.add(map);
        }
        return list;
    }

    @Override
    public List<Singer> findSingerBySid(Integer s_id) {
        SingerExample example = new SingerExample();
        example.createCriteria().andS_idEqualTo(s_id);
        return this.singerMapper.selectByExample(example);
    }

    @Override
    public Integer insertSinger(Singer singer) {
        this.singerMapper.insertSelective(singer);
        return singer.getS_id();
    }

    @Override
    public int deleteSingers(Integer[] sids) {
        for (Integer sid : sids){
            if(this.singerMapper.deleteByPrimaryKey(
                    sid
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
