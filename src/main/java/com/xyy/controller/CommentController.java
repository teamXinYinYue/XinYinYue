package com.xyy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyy.po.Comment;
import com.xyy.service.CommentService;
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
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/findManyCommentBymid" )
    public HashMap findManyCommentBymid(Integer mid) {

        HashMap hashMap=new HashMap();

        List<Comment> list=commentService.findCommentByMusic(mid);

        if( list.size()!=0) {
            hashMap.put("commentlist",list);
            hashMap.put("msg",true);

            return hashMap;
        }
        hashMap.put("msg",false);

        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/findManyCommentByuid" )
    public HashMap findManyCommentByuid(Integer uid) {

        HashMap hashMap=new HashMap();

        List<Comment> list=commentService.findCommentByUid(uid);

        if( list.size()!=0) {

            hashMap.put("commentlist",list);
            hashMap.put("msg",true);
            return hashMap;
        }
        hashMap.put("msg",false);
        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/addOneCommentBycomment",method = RequestMethod.POST)
    public HashMap addOneCommentByComment(@RequestBody Comment comment) {

        HashMap hashMap=new HashMap();
        comment.setCo_date(new Date());
        int rows=commentService.insertComment(comment);

        if(rows>0) {

            hashMap.put("msg",true);

        }else{

            hashMap.put("msg",false);
        }

        return hashMap;
    }


    @ResponseBody
    @RequestMapping(value = "/deleteManyCommentBycoids",method = RequestMethod.POST)
    public HashMap deleteManyCommentBycoids(Integer[] coids) {

        HashMap hashMap=new HashMap();

        int rows=commentService.deleteComments(coids);

        if(rows>0) {
            hashMap.put("msg",true);


        } else {
            hashMap.put("msg",false);


        }

        return hashMap;
    }


    @ResponseBody
    @RequestMapping(value = "/updateOneCommentBycomment",method = RequestMethod.POST)
    public HashMap updateOneCommentByComment(@RequestBody Comment comment) {

        HashMap hashMap=new HashMap();

        int rows=commentService.updateComment(comment);

        if(rows>0) {
            hashMap.put("msg",true);


        } else {
            hashMap.put("msg",false);


        }

        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/pageManyCommentBymid")
    public  HashMap pageManyCommentBymid(Integer mid,Integer pageNum,Integer pageSize) {
        if(pageNum==null){
            pageNum=1;
        }else if(pageNum<1){
            pageNum=1;
        }

        if(pageSize==null){
            pageSize=3;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Comment> list = commentService.findCommentByMusic(mid);
        PageInfo<Comment> info = new PageInfo(list);
        int totalPage=info.getPages();


        HashMap hashMap=new HashMap();
        hashMap.put("pagecommentlist",list);
        hashMap.put("pageNum",pageNum);
        hashMap.put("pageSize",pageSize);
        hashMap.put("totalPage",totalPage);
        return hashMap;

    }

    @ResponseBody
    @RequestMapping(value = "/pageManyCommentByuid")
    public  HashMap pageManyCommentByuid(Integer uid,Integer pageNum,Integer pageSize) {
        if(pageNum==null){
            pageNum=1;
        }else if(pageNum<1){
            pageNum=1;
        }

        if(pageSize==null){
            pageSize=3;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Comment> list = commentService.findCommentByUid(uid);
        PageInfo<Comment> info = new PageInfo(list);
        int totalPage=info.getPages();



        HashMap hashMap=new HashMap();
        hashMap.put("pagecommentlist",list);
        hashMap.put("pageNum",pageNum);
        hashMap.put("pageSize",pageSize);
        hashMap.put("totalPage",totalPage);
        return hashMap;

    }
}
