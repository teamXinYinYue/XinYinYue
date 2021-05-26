package com.xyy.service.impl;

import com.xyy.dao.LocationMapper;
import com.xyy.po.Location;
import com.xyy.po.LocationExample;
import com.xyy.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("locationService")
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationMapper locationMapper;
    @Override
    public List<Location> findLocation() {
        LocationExample example=new LocationExample();
        example.createCriteria().andL_idIsNotNull();
        return this.locationMapper.selectByExample(example);
    }

    @Override
    public List<Location> findLocationByLid(Integer l_id) {
        LocationExample example=new LocationExample();
        example.createCriteria().andL_idEqualTo(l_id);
        return this.locationMapper.selectByExample(example);
    }

    @Override
    public List<Location> findLocationBySid(Integer s_id) {
        LocationExample example=new LocationExample();
        example.createCriteria().andS_idEqualTo(s_id);
        example.setOrderByClause("l_id desc");
        return this.locationMapper.selectByExample(example);
    }

    @Override
    public Integer insertLocation(Location location) {
        this.locationMapper.insertSelective(location);
        return location.getL_id();
    }

    @Override
    public int deleteLocations(Integer[] lids) {
        for (Integer lid : lids){
            if(this.locationMapper.deleteByPrimaryKey(
                    lid
            )==0){
                throw new RuntimeException("未删除成功");
            }
        }
        return 1;
    }

    @Override
    public int updateLocation(Location location) {
        LocationExample example = new LocationExample();
        example.createCriteria().andL_idEqualTo(location.getL_id());
        return this.locationMapper.updateByExample(location,example);
    }
}
