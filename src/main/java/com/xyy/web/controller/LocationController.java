package com.xyy.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyy.po.*;
import com.xyy.service.LocationService;
import com.xyy.utils.JsonInfo;
import com.xyy.utils.MyPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @ResponseBody
    @RequestMapping(value = "/findLocation",method = RequestMethod.POST)
    public JsonInfo findLocation() {

        JsonInfo jsonInfo=new JsonInfo();

        List<Location> list=locationService.findLocation();

        if( list.size()!=0) {

            jsonInfo.setObj(list);

            return jsonInfo;
        }
        jsonInfo.setMsg("查找失败");

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/findLocationByCategory",method = RequestMethod.POST)
    public JsonInfo findLocationByCategory(@RequestBody Category category) {

        JsonInfo jsonInfo=new JsonInfo();

        List<Location> list=locationService.findLocationByLid(category.getL_id());

        if( list.size()!=0) {

            jsonInfo.setObj(list);

            return jsonInfo;
        }
        jsonInfo.setMsg("查找失败");

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/findLocationBySinger",method = RequestMethod.POST)
    public JsonInfo findLocationBySinger(@RequestBody Singer singer) {

        JsonInfo jsonInfo=new JsonInfo();

        List<Location> list=locationService.findLocationByLid(singer.getL_id());

        if( list.size()!=0) {

            jsonInfo.setObj(list);

            return jsonInfo;
        }
        jsonInfo.setMsg("查找失败");

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/addLocation",method = RequestMethod.POST)
    public JsonInfo addLocation(@RequestBody Location location) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=locationService.insertLocation(location);

        if(rows<=0) {

            jsonInfo.setMsg("添加失败，请重试！");

        }else{

            jsonInfo.setMsg("添加成功");
        }

        return jsonInfo;
    }


    @ResponseBody
    @RequestMapping(value = "/deleteLocation",method = RequestMethod.POST)
    public JsonInfo deleteLocation(@RequestBody List<Location> locations) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=locationService.deleteLocations(locations);

        if(rows>0) {

            jsonInfo.setMsg("删除成功");

        } else {

            jsonInfo.setMsg("删除失败，请重试！");

        }

        return jsonInfo;
    }


    @ResponseBody
    @RequestMapping(value = "/updateLocation",method = RequestMethod.POST)
    public JsonInfo updateLocation(@RequestBody Location location) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=locationService.updateLocation(location);

        if(rows>0) {

            jsonInfo.setMsg("更新成功");

        } else {

            jsonInfo.setMsg("更新失败，请重试！");

        }

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/LocationPage")
    public  MyPageInfo<Location> LocationPage(@RequestBody  MyPageInfo<Location> myPageInfo) {
        Integer pageNum=myPageInfo.getPageNum();
        Integer pageSize=myPageInfo.getPageSize();
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


        MyPageInfo<Location> mypage=new MyPageInfo<>(list,pageNum,pageSize,totalPage);
        return mypage;

    }

    @ResponseBody
    @RequestMapping(value = "/LocationPageByCategory")
    public  MyPageInfo<Location> LocationPageByCategory(@RequestBody  MyPageInfo<Location> myPageInfo) {
        Integer pageNum=myPageInfo.getPageNum();
        Integer pageSize=myPageInfo.getPageSize();
        Category category=(Category)myPageInfo.getObj();
        if(pageNum==null){
            pageNum=1;
        }else if(pageNum<1){
            pageNum=1;
        }

        if(pageSize==null){
            pageSize=3;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Location> list = locationService.findLocationByLid(category.getL_id());
        PageInfo<Location> info = new PageInfo(list);
        int totalPage=info.getPages();


        MyPageInfo<Location> mypage=new MyPageInfo<>(list,pageNum,pageSize,totalPage);
        return mypage;

    }

    @ResponseBody
    @RequestMapping(value = "/musicPageBySinger")
    public MyPageInfo<Location> musicPageBySinger(@RequestBody MyPageInfo<Location> myPageInfo) {
        Integer pageNum=myPageInfo.getPageNum();
        Integer pageSize=myPageInfo.getPageSize();
        Singer singer=(Singer)myPageInfo.getObj();
        if(pageNum==null){
            pageNum=1;
        }else if(pageNum<1){
            pageNum=1;
        }

        if(pageSize==null){
            pageSize=3;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Location> list = locationService.findLocationByLid(singer.getL_id());
        PageInfo<Location> info = new PageInfo(list);
        int totalPage=info.getPages();



        MyPageInfo<Location> mypage=new MyPageInfo<>(list,pageNum,pageSize,totalPage);
        return mypage;

    }
}
