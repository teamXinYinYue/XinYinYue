package com.xyy.service;

import com.xyy.po.Location;

import java.util.List;


public interface LocationService {

    List<Location> findLocation();

    List<Location> findLocationByLid(Integer l_id);

    int insertLocation(Location location);

    int deleteLocations(List<Location> locations);

    int updateLocation(Location location);
}
