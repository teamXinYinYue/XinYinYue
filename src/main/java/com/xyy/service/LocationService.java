package com.xyy.service;

import com.xyy.po.Location;

import java.util.List;


public interface LocationService {

    List<Location> findLocation();

    List<Location> findLocationByLid(Integer l_id);

    List<Location> findLocationBySid(Integer s_id);

    Integer insertLocation(Location location);

    int deleteLocations(Integer[] lids);

    int updateLocation(Location location);
}
