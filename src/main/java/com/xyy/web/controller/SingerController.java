package com.xyy.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyy.po.Music;
import com.xyy.po.Singer;
import com.xyy.po.User;
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
public class SingerController {
    @Autowired
    private SingerService singerService;

    @ResponseBody
    @RequestMapping(value = "/findSinger",method = RequestMethod.POST)
    public JsonInfo findSinger() {

        JsonInfo jsonInfo=new JsonInfo();

        List<Singer> list=singerService.findSinger();

        if( list.size()!=0) {

            jsonInfo.setObj(list);

            return jsonInfo;
        }
        jsonInfo.setMsg("查找失败");

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/findSingerByName",method = RequestMethod.POST)
    public JsonInfo findSingerByName(@RequestBody Singer singer) {

        JsonInfo jsonInfo=new JsonInfo();

        List<Singer> list=singerService.findSingerByName(singer.getS_name());

        if( list.size()!=0) {

            jsonInfo.setObj(list);

            return jsonInfo;
        }
        jsonInfo.setMsg("查找失败");

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/findSingerBySid",method = RequestMethod.POST)
    public JsonInfo findSingerBySid(@RequestBody Singer singer) {

        JsonInfo jsonInfo=new JsonInfo();

        List<Singer> list=singerService.findSingerBySid(singer.getS_id());

        if( list.size()!=0) {

            jsonInfo.setObj(list);

            return jsonInfo;
        }
        jsonInfo.setMsg("查找失败");

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/insertSinger",method = RequestMethod.POST)
    public JsonInfo insertSinger(@RequestBody Singer singer) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=singerService.insertSinger(singer);

        if(rows<=0) {

            jsonInfo.setMsg("添加失败，请重试！");

        }else{

            jsonInfo.setMsg("添加成功");
        }

        return jsonInfo;
    }


    @ResponseBody
    @RequestMapping(value = "/deleteSingers",method = RequestMethod.POST)
    public JsonInfo deleteSingers(@RequestBody List<Singer> singers) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=singerService.deleteSingers(singers);

        if(rows>0) {

            jsonInfo.setMsg("删除成功");

        } else {

            jsonInfo.setMsg("删除失败，请重试！");

        }

        return jsonInfo;
    }


    @ResponseBody
    @RequestMapping(value = "/updateSinger",method = RequestMethod.POST)
    public JsonInfo updateSinger(@RequestBody Singer singer) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=singerService.updateSinger(singer);

        if(rows>0) {

            jsonInfo.setMsg("更新成功");

        } else {

            jsonInfo.setMsg("更新失败，请重试！");

        }

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/singerPage")
    public MyPageInfo<Singer> singerPage(@RequestBody  MyPageInfo<Singer>  myPageInfo) {
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
        List<Singer> list = singerService.findSinger();
        PageInfo<Singer> info = new PageInfo(list);
        int totalPage=info.getPages();


        MyPageInfo<Singer> mypage=new MyPageInfo<>(list,pageNum,pageSize,totalPage);
        return mypage;

    }
}
