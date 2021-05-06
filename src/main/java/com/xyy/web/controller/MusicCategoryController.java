package com.xyy.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyy.po.Category;
import com.xyy.po.Music;
import com.xyy.service.MusicCategoryService;
import com.xyy.utils.JsonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MusicCategoryController {
    @Autowired
    private MusicCategoryService musicCategoryService;

    @ResponseBody
    @RequestMapping(value = "/findMusicCategory",method = RequestMethod.POST)
    public JsonInfo findMusicCategory() {

        JsonInfo jsonInfo=new JsonInfo();

        List<Category> list=musicCategoryService.findMusicCategory();

        if( list.size()!=0) {

            jsonInfo.setObj(list);

            return jsonInfo;
        }
        jsonInfo.setMsg("查找失败");

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/addMusicCategory",method = RequestMethod.POST)
    public JsonInfo addMusicCategory(@RequestBody Category category) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=musicCategoryService.insertCategory(category);

        if(rows<=0) {

            jsonInfo.setMsg("添加失败，请重试！");

        }else{

            jsonInfo.setMsg("添加成功");
        }

        return jsonInfo;
    }


    @ResponseBody
    @RequestMapping(value = "/deleteMusicCategory",method = RequestMethod.POST)
    public JsonInfo deleteMusicCategory(Integer[] cids) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=musicCategoryService.deleteCategorys(cids);

        if(rows>0) {

            jsonInfo.setMsg("删除成功");

        } else {

            jsonInfo.setMsg("删除失败，请重试！");

        }

        return jsonInfo;
    }


    @ResponseBody
    @RequestMapping(value = "/updateMusicCategory",method = RequestMethod.POST)
    public JsonInfo updateMusicCategory(@RequestBody Category category) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=musicCategoryService.updateMusicCategory(category);

        if(rows>0) {

            jsonInfo.setMsg("更新成功");

        } else {

            jsonInfo.setMsg("更新失败，请重试！");

        }

        return jsonInfo;
    }


}
