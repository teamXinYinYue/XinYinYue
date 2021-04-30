package com.xyy.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyy.po.Playlist;
import com.xyy.po.Singer;
import com.xyy.utils.JsonInfo;
import com.xyy.po.Plmusic;
import com.xyy.service.PlmusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class PlmusicController {

    @Autowired
    private PlmusicService plmusicService;

    @ResponseBody
    @RequestMapping(value = "/findPlmusic",method = RequestMethod.POST)
    public JsonInfo findPlmusic(@RequestBody Playlist playlist) {

        JsonInfo jsonInfo=new JsonInfo();

        List<Plmusic> list=plmusicService.findPlmusic(playlist.getU_id(),playlist.getP_name());

        if( list.size()!=0) {

            jsonInfo.setObj(list);

            return jsonInfo;
        }
        jsonInfo.setMsg("查找失败");

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/addPlmusic",method = RequestMethod.POST)
    public JsonInfo addPlmusic(@RequestBody List<Plmusic> plmusics) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=plmusicService.insertPlmusic(plmusics);

        if(rows<=0) {

            jsonInfo.setMsg("歌单歌曲添加失败，请重试！");

        }else{

            jsonInfo.setMsg("歌单歌曲添加成功");
        }

        return jsonInfo;
    }


    @ResponseBody
    @RequestMapping(value = "/deletePlmusic",method = RequestMethod.POST)
    public JsonInfo deletePlmusic(@RequestBody List<Plmusic> plmusics) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=plmusicService.deletePlmusic(plmusics);

        if(rows>0) {

            jsonInfo.setMsg("歌单歌曲删除成功");

        } else {

            jsonInfo.setMsg("歌单歌曲删除失败，请重试！");

        }

        return jsonInfo;
    }



}
