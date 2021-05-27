package com.xyy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyy.po.Music;
import com.xyy.service.MusicCategoryService;
import com.xyy.service.MusicService;
import com.xyy.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Controller
public class MusicController {
    @Autowired
    private MusicService musicService;

    @Autowired
    private SingerService singerService;

    @Autowired
    private MusicCategoryService musicCategoryService;

    //真正的增加歌曲功能在UploadController中
    //测试类
    @ResponseBody
    @RequestMapping(value = "/addOneMusicBymusic" )
    public HashMap addOneMusicBymusic(@RequestBody Music music){
        HashMap hashMap=new HashMap();
        music.setMdate(new Date());
        Integer m_id=musicService.insertMusic(music);
        if(m_id!=null){
            hashMap.put("msg",true);
        } else {
            hashMap.put("msg",false);
        }
        return hashMap;
    }


    @ResponseBody
    @RequestMapping(value = "/orderManyMusicBysize" )
    public HashMap orderManyMusicBysize(Integer size) {

        HashMap hashMap=new HashMap();

        if(size==null){
            size=10;
        }
        List<Music> list=musicService.findMusicPaiHang(size);

        if( list.size()!=0) {

            hashMap.put("musiclist",list);
            hashMap.put("msg",true);

            return hashMap;
        }
        hashMap.put("msg",false);


        return hashMap;
    }




    @ResponseBody
    @RequestMapping(value = "/deleteManyMusicBymids",method = RequestMethod.POST)
    public HashMap deleteManyMusicBymids(Integer[] mids) {

        HashMap hashMap=new HashMap();

        int rows=musicService.deleteMusics(mids);

        if(rows>0) {

            hashMap.put("msg",true);

        } else {
            hashMap.put("msg",false);

        }

        return hashMap;
    }


    @ResponseBody
    @RequestMapping(value = "/updateOneMusicBymusic" ,method = RequestMethod.POST)
    public HashMap updateOneMusicBymusic(@RequestBody Music music) {

        HashMap hashMap=new HashMap();

        int rows=musicService.updateMusic(music);

        if(rows>0) {
            hashMap.put("msg",true);


        } else {
            hashMap.put("msg",false);


        }

        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/updateOneMusicHotBymid" ,method = RequestMethod.POST)
    public HashMap updateOneMusicHotBymid(Integer mid) {

        HashMap hashMap=new HashMap();

        int rows=musicService.updateMusicHot(mid);

        if(rows>0) {
            hashMap.put("msg",true);


        } else {
            hashMap.put("msg",false);

        }

        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/pageManyMusic")
    public HashMap pageManyMusic(Integer pageNum,Integer pageSize) {
        if(pageNum==null){
            pageNum=1;
        }else if(pageNum<1){
            pageNum=1;
        }

        if(pageSize==null){
            pageSize=3;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String,Object>> list = musicService.findMusic();
        PageInfo<HashMap<String,Object>> info = new PageInfo(list);
        int totalPage=info.getPages();

        HashMap hashMap=new HashMap();
        hashMap.put("pagemusiclist",list);
        hashMap.put("pageNum",pageNum);
        hashMap.put("pageSize",pageSize);
        hashMap.put("totalPage",totalPage);
        return hashMap;

    }


    @ResponseBody
    @RequestMapping(value = "/pageManyMusicByMC" )
    public HashMap pageManyMusicByMC(String cname,String sname,String mname,Integer pageNum,Integer pageSize) {
        Integer cid=null;
        Integer sid=null;

        if(cname!=null){
            cid=musicCategoryService.findMusicCategoryIDbyName(cname);
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
        List<HashMap<String,Object>> list = musicService.findMusicByMC(cid,sid,mname);
        PageInfo<HashMap<String,Object>> info = new PageInfo(list);
        int totalPage=info.getPages();


        HashMap hashMap=new HashMap();
        hashMap.put("pagemusiclist",list);
        hashMap.put("pageNum",pageNum);
        hashMap.put("pageSize",pageSize);
        hashMap.put("totalPage",totalPage);
        return hashMap;

    }


}
