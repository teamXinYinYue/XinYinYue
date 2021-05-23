package com.xyy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyy.po.Location;
import com.xyy.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @ResponseBody
    @RequestMapping(value = "/findManyLocationByNone" )
    public HashMap findManyLocationByNone() {

        HashMap hashMap=new HashMap();

        List<Location> list=locationService.findLocation();

        if( list.size()!=0) {
            hashMap.put("locationlist",list);
            hashMap.put("msg",true);

            return hashMap;
        }
        hashMap.put("msg",false);


        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/findManyLocationBycalid" )
    public HashMap findManyLocationBycalid(Integer calid) {

        HashMap hashMap=new HashMap();

        List<Location> list=locationService.findLocationByLid(calid);

        if( list.size()!=0) {
            hashMap.put("locationlist",list);
            hashMap.put("msg",true);

            return hashMap;
        }
        hashMap.put("msg",false);

        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/findManyLoactionByslid" )
    public HashMap findManyLoactionByslid(Integer slid) {

        HashMap hashMap=new HashMap();

        List<Location> list=locationService.findLocationByLid(slid);

        if( list.size()!=0) {
            hashMap.put("locationlist",list);
            hashMap.put("msg",true);

            return hashMap;
        }
        hashMap.put("msg",false);

        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/addOneLocationBylocation",method = RequestMethod.POST)
    public HashMap addOneLocationBylocation(@RequestBody Location location) {

        HashMap hashMap=new HashMap();

        int rows=locationService.insertLocation(location);

        if(rows>0) {

            hashMap.put("msg",true);

        }else{

            hashMap.put("msg",false);
        }

        return hashMap;
    }


    @ResponseBody
    @RequestMapping(value = "/deleteManyLocationBylids",method = RequestMethod.POST)
    public HashMap deleteManyLocationBylids(Integer[] lids) {

        HashMap hashMap=new HashMap();

        int rows=locationService.deleteLocations(lids);

        if(rows>0) {

            hashMap.put("msg",true);
        } else {

            hashMap.put("msg",false);
        }

        return hashMap;
    }


    @ResponseBody
    @RequestMapping(value = "/updateOneLocationBylocation",method = RequestMethod.POST)
    public HashMap updateOneLocationBylocation(@RequestBody Location location) {

        HashMap hashMap=new HashMap();

        int rows=locationService.updateLocation(location);

        if(rows>0) {
            hashMap.put("msg",true);


        } else {
            hashMap.put("msg",false);


        }

        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/pageManyLocation")
    public  HashMap pageManyLocation(Integer pageNum,Integer pageSize) {
        if(pageNum==null){
            pageNum=1;
        }else if(pageNum<1){
            pageNum=1;
        }

        if(pageSize==null){
            pageSize=3;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Location> list = locationService.findLocation();
        PageInfo<Location> info = new PageInfo(list);
        int totalPage=info.getPages();

        HashMap hashMap=new HashMap();
        hashMap.put("pagelocationlist",list);
        hashMap.put("pageNum",pageNum);
        hashMap.put("pageSize",pageSize);
        hashMap.put("totalPage",totalPage);
        return hashMap;

    }

    @ResponseBody
    @RequestMapping(value = "/pageManyLocationBycalid")
    public  HashMap pageManyLocationBycalid(Integer clid,Integer pageNum,Integer pageSize) {
        if(pageNum==null){
            pageNum=1;
        }else if(pageNum<1){
            pageNum=1;
        }

        if(pageSize==null){
            pageSize=3;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Location> list = locationService.findLocationByLid(clid);
        PageInfo<Location> info = new PageInfo(list);
        int totalPage=info.getPages();


        HashMap hashMap=new HashMap();
        hashMap.put("pagelocationlist",list);
        hashMap.put("pageNum",pageNum);
        hashMap.put("pageSize",pageSize);
        hashMap.put("totalPage",totalPage);
        return hashMap;

    }

    @ResponseBody
    @RequestMapping(value = "/pageManyLocationByslid")
    public HashMap pageManyLocationByslid(Integer slid,Integer pageNum,Integer pageSize) {
        if(pageNum==null){
            pageNum=1;
        }else if(pageNum<1){
            pageNum=1;
        }

        if(pageSize==null){
            pageSize=3;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Location> list = locationService.findLocationByLid(slid);
        PageInfo<Location> info = new PageInfo(list);
        int totalPage=info.getPages();



        HashMap hashMap=new HashMap();
        hashMap.put("pagelocationlist",list);
        hashMap.put("pageNum",pageNum);
        hashMap.put("pageSize",pageSize);
        hashMap.put("totalPage",totalPage);
        return hashMap;

    }
}
