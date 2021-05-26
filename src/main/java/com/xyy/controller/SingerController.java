package com.xyy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyy.po.Singer;
import com.xyy.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;


@Controller
public class SingerController {
    @Autowired
    private SingerService singerService;

    @ResponseBody
    @RequestMapping(value = "/findManySingerByNone" )
    public HashMap findManySingerByNone() {

        HashMap hashMap=new HashMap();

        List<Singer> list=singerService.findSinger();

        if( list.size()!=0) {

            hashMap.put("singerlist",list);
            hashMap.put("msg",true);

            return hashMap;
        }
        hashMap.put("msg",false);

        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/findManySingerBysname" )
    public HashMap findManySingerBysname(String sname) {

        HashMap hashMap=new HashMap();

        List<Singer> list=singerService.findSingerByName(sname);

        if( list.size()!=0) {

            hashMap.put("singerlist",list);
            hashMap.put("msg",true);

            return hashMap;
        }
        hashMap.put("msg",false);

        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/findManySingerBysid" )
    public HashMap findManySingerBysid(Integer sid) {

        HashMap hashMap=new HashMap();

        List<Singer> list=singerService.findSingerBySid(sid);

        if( list.size()!=0) {

            hashMap.put("singerlist",list);
            hashMap.put("msg",true);

            return hashMap;
        }
        hashMap.put("msg",false);

        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/addOneSingerBysinger",method = RequestMethod.POST)
    public HashMap addOneSingerBysinger(@RequestBody Singer singer) {

        HashMap hashMap=new HashMap();

        Integer sid=singerService.insertSinger(singer);

        singer.setS_id(sid);
        if(sid!=null) {

            hashMap.put("msg",true);


        }else{
            hashMap.put("msg",false);

        }

        return hashMap;
    }


    @ResponseBody
    @RequestMapping(value = "/deleteManySingerBysids",method = RequestMethod.POST)
    public HashMap deleteManySingerBysids(Integer[] sids) {

        HashMap hashMap=new HashMap();

        int rows=singerService.deleteSingers(sids);

        if(rows>0) {
            hashMap.put("msg",true);


        } else {
            hashMap.put("msg",false);

        }

        return hashMap;
    }


    @ResponseBody
    @RequestMapping(value = "/updateOneSingerBysinger",method = RequestMethod.POST)
    public HashMap updateOneSingerBysinger(@RequestBody Singer singer) {

        HashMap hashMap=new HashMap();

        int rows=singerService.updateSinger(singer);

        if(rows>0) {
            hashMap.put("msg",true);


        } else {

            hashMap.put("msg",false);

        }

        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/pageMangSingerBysname")
    public HashMap pageMangSingerBysname(String sname,Integer pageNum,Integer pageSize) {
        if(pageNum==null){
            pageNum=1;
        }else if(pageNum<1){
            pageNum=1;
        }

        if(pageSize==null){
            pageSize=3;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String,Object>> list=null;
        if(sname!=null){
            list = singerService.findSingerByNameAlsoBackimg(sname);
        }else{
            list = singerService.findSingerAlsoBackimg();
        }

        PageInfo<Singer> info = new PageInfo(list);
        int totalPage=info.getPages();

        HashMap hashMap=new HashMap();
        hashMap.put("pagesingerlist",list);
        hashMap.put("pageNum",pageNum);
        hashMap.put("pageSize",pageSize);
        hashMap.put("totalPage",totalPage);
        return hashMap;

    }


}
