package com.xyy.service.impl;

import com.xyy.dao.LocationMapper;
import com.xyy.po.Comment;
import com.xyy.po.CommentExample;
import com.xyy.po.Location;
import com.xyy.po.LocationExample;
import com.xyy.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("locationService")
public class LocationServiceImpl implements LocationService {

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
    public int insertLocation(Location location) {
        return this.locationMapper.insert(location);
    }

    @Override
    public int deleteLocations(List<Location> locations) {
        for (Location location : locations){
            if(this.locationMapper.deleteByPrimaryKey(
                    location.getL_id()
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
