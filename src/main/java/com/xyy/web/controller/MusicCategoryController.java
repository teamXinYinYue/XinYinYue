package com.xyy.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyy.po.Category;
import com.xyy.po.Music;
import com.xyy.service.MusicCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;


@Controller
public class MusicCategoryController {
    @Autowired
    private MusicCategoryService musicCategoryService;

    @ResponseBody
    @RequestMapping(value = "/findManyCategoryByNone")
    public HashMap findManyCategoryByNone() {

        HashMap hashMap=new HashMap();

        List<Category> list=musicCategoryService.findMusicCategory();

        if( list.size()!=0) {

            hashMap.put("categorylist",list);
            hashMap.put("msg",true);
            return hashMap;
        }
        hashMap.put("msg",false);
        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/addOneCategoryBycategory",method = RequestMethod.POST)
    public HashMap addOneCategoryBycategory(@RequestBody Category category) {

        HashMap hashMap=new HashMap();

        int rows=musicCategoryService.insertCategory(category);

        if(rows>0) {
            hashMap.put("msg",true);


        }else{
            hashMap.put("msg",false);

        }

        return hashMap;
    }


    @ResponseBody
    @RequestMapping(value = "/deleteManyCategoryBycids",method = RequestMethod.POST)
    public HashMap deleteManyCategoryBycids(Integer[] cids) {

        HashMap hashMap=new HashMap();

        int rows=musicCategoryService.deleteCategorys(cids);

        if(rows>0) {
            hashMap.put("msg",true);


        } else {
            hashMap.put("msg",false);


        }

        return hashMap;
    }


    @ResponseBody
    @RequestMapping(value = "/updateOneCategoryBycategory",method = RequestMethod.POST)
    public HashMap updateOneCategoryBycategory(@RequestBody Category category) {

        HashMap hashMap=new HashMap();

        int rows=musicCategoryService.updateMusicCategory(category);

        if(rows>0) {
            hashMap.put("msg",true);


        } else {
            hashMap.put("msg",false);


        }

        return hashMap;
    }


}
