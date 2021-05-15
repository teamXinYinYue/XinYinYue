package com.xyy.web.controller;

import com.xyy.po.Plmusic;
import com.xyy.service.PlmusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;


@Controller
public class PlmusicController {

    @Autowired
    private PlmusicService plmusicService;

    @ResponseBody
    @RequestMapping(value = "/findManyPlmusicByuidpname" )
    public HashMap findManyPlmusicByuidpname(Integer uid, String pname) {

        HashMap hashMap=new HashMap();

        List<Plmusic> list=plmusicService.findPlmusic(uid,pname);

        if( list.size()!=0) {

            hashMap.put("plmusiclist",list);

            return hashMap;
        }
        hashMap.put("msg","查找失败");

        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/addManyPlmusicByplmidspnameuid",method = RequestMethod.POST)
    public HashMap addManyPlmusicByplmidspnameuid(Integer[] plmids,String pname,Integer uid) {

        HashMap hashMap=new HashMap();

        int rows=plmusicService.insertPlmusic(plmids,pname,uid);

        if(rows<=0) {

            hashMap.put("msg","歌单歌曲添加失败，请重试！");


        }else{
            hashMap.put("msg","歌单歌曲添加成功");
        }

        return hashMap;
    }


    @ResponseBody
    @RequestMapping(value = "/deleteManyPlmusicByplmidpnameuid",method = RequestMethod.POST)
    public HashMap deleteManyPlmusicByplmidpnameuid(Integer[] plmids,String pname,Integer uid) {

        HashMap hashMap=new HashMap();

        int rows=plmusicService.deletePlmusic(plmids,pname,uid);

        if(rows>0) {

            hashMap.put("msg","歌单歌曲删除成功");

        } else {

            hashMap.put("msg","歌单歌曲删除失败，请重试！");

        }

        return hashMap;
    }



}
