package com.xyy.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyy.po.Music;
import com.xyy.po.Singer;
import com.xyy.po.User;
import com.xyy.service.MusicCategoryService;
import com.xyy.service.MusicService;
import com.xyy.service.SingerService;
import com.xyy.utils.JsonInfo;
import com.xyy.utils.MyPageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MusicController {
    @Autowired
    private MusicService musicService;

    @Autowired
    private SingerService singerService;

    @Autowired
    private MusicCategoryService musicCategoryService;

    @ResponseBody
    @RequestMapping(value = "/findMusicBySid",method = RequestMethod.POST)
    public JsonInfo findMusicPaiHang(Integer size) {

        JsonInfo jsonInfo=new JsonInfo();

        List<Music> list=musicService.findMusicPaiHang(size);

        if( list.size()!=0) {

            jsonInfo.setObj(list);

            return jsonInfo;
        }
        jsonInfo.setMsg("查找失败");

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/addMusic",method = RequestMethod.POST)
    public JsonInfo addMusic(@RequestBody Music music) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=musicService.insertMusic(music);

        if(rows<=0) {

            jsonInfo.setMsg("添加失败，请重试！");

        }else{

            jsonInfo.setMsg("添加成功");
        }

        return jsonInfo;
    }


    @ResponseBody
    @RequestMapping(value = "/deleteMusic",method = RequestMethod.POST)
    public JsonInfo deleteMusic(Integer[] mids) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=musicService.deleteMusics(mids);

        if(rows>0) {

            jsonInfo.setMsg("删除成功");

        } else {

            jsonInfo.setMsg("删除失败，请重试！");

        }

        return jsonInfo;
    }


    @ResponseBody
    @RequestMapping(value = "/updateMusic",method = RequestMethod.POST)
    public JsonInfo updateMusic(@RequestBody Music music) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=musicService.updateMusic(music);

        if(rows>0) {

            jsonInfo.setMsg("更新成功");

        } else {

            jsonInfo.setMsg("更新失败，请重试！");

        }

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/musicPage")
    public MyPageInfo<Music> musicPage(Integer pageNum,Integer pageSize) {
        if(pageNum==null){
            pageNum=1;
        }else if(pageNum<1){
            pageNum=1;
        }

        if(pageSize==null){
            pageSize=3;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Music> list = musicService.findMusic();
        PageInfo<Music> info = new PageInfo(list);
        int totalPage=info.getPages();


        MyPageInfo<Music> mypage=new MyPageInfo<>(list,pageNum,pageSize,totalPage);
        return mypage;

    }


    @ResponseBody
    @RequestMapping(value = "/findMusicByMC",method = RequestMethod.POST)
    public MyPageInfo<Music> musicPageByMC(String cname,String sname,String mname,Integer pageNum,Integer pageSize) {
        Integer cid=null;
        Integer sid=null;

        if(cname!=null){
            cid=musicCategoryService.findMusicCategoryIDbyname(cname);
        }
        if(sname!=null){
            sid=singerService.findSingerIDByName(sname);
        }
        if(pageNum==null){
            pageNum=1;
        }else if(pageNum<1){
            pageNum=1;
        }

        if(pageSize==null){
            pageSize=3;
        }


        PageHelper.startPage(pageNum, pageSize);
        List<Music> list = musicService.findMusicByMC(cid,sid,mname);
        PageInfo<Music> info = new PageInfo(list);
        int totalPage=info.getPages();


        MyPageInfo<Music> mypage=new MyPageInfo<>(list,pageNum,pageSize,totalPage);
        return mypage;

    }


}
