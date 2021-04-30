package com.xyy.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyy.po.Comment;
import com.xyy.po.Music;
import com.xyy.po.User;
import com.xyy.service.CommentService;
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
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/findCommentByMusic",method = RequestMethod.POST)
    public JsonInfo findCommentByMusic(@RequestBody Music music) {

        JsonInfo jsonInfo=new JsonInfo();

        List<Comment> list=commentService.findCommentByMusic(music.getM_id());

        if( list.size()!=0) {

            jsonInfo.setObj(list);

            return jsonInfo;
        }
        jsonInfo.setMsg("查找失败");

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/findCommentByUid",method = RequestMethod.POST)
    public JsonInfo findCommentByUid(@RequestBody User user) {

        JsonInfo jsonInfo=new JsonInfo();

        List<Comment> list=commentService.findCommentByUid(user.getU_id());

        if( list.size()!=0) {

            jsonInfo.setObj(list);

            return jsonInfo;
        }
        jsonInfo.setMsg("查找失败");

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    public JsonInfo addComment(@RequestBody Comment comment) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=commentService.insertComment(comment);

        if(rows<=0) {

            jsonInfo.setMsg("评论添加失败，请重试！");

        }else{

            jsonInfo.setMsg("评论添加成功");
        }

        return jsonInfo;
    }


    @ResponseBody
    @RequestMapping(value = "/deleteComment",method = RequestMethod.POST)
    public JsonInfo deleteComment(@RequestBody List<Comment> comments) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=commentService.deleteComments(comments);

        if(rows>0) {

            jsonInfo.setMsg("评论删除成功");

        } else {

            jsonInfo.setMsg("评论删除失败，请重试！");

        }

        return jsonInfo;
    }


    @ResponseBody
    @RequestMapping(value = "/updateComment",method = RequestMethod.POST)
    public JsonInfo updateComment(@RequestBody Comment comment) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=commentService.updateComment(comment);

        if(rows>0) {

            jsonInfo.setMsg("评论更新成功");

        } else {

            jsonInfo.setMsg("评论更新失败，请重试！");

        }

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/musicPageByMid")
    public  MyPageInfo<Comment> musicPageByMid(@RequestBody  MyPageInfo<Comment> myPageInfo) {
        Integer pageNum=myPageInfo.getPageNum();
        Integer pageSize=myPageInfo.getPageSize();
        Music music=(Music)myPageInfo.getObj();
        if(pageNum==null){
            pageNum=1;
        }else if(pageNum<1){
            pageNum=1;
        }

        if(pageSize==null){
            pageSize=3;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Comment> list = commentService.findCommentByMusic(music.getM_id());
        PageInfo<Comment> info = new PageInfo(list);
        int totalPage=info.getPages();


        MyPageInfo<Comment> mypage=new MyPageInfo<>(list,pageNum,pageSize,totalPage);
        return mypage;

    }

    @ResponseBody
    @RequestMapping(value = "/musicPageByUid")
    public  MyPageInfo<Comment> musicPageByUid(@RequestBody MyPageInfo<Comment> myPageInfo) {
        Integer pageNum=myPageInfo.getPageNum();
        Integer pageSize=myPageInfo.getPageSize();
        User user=(User)myPageInfo.getObj();
        if(pageNum==null){
            pageNum=1;
        }else if(pageNum<1){
            pageNum=1;
        }

        if(pageSize==null){
            pageSize=3;
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Comment> list = commentService.findCommentByUid(user.getU_id());
        PageInfo<Comment> info = new PageInfo(list);
        int totalPage=info.getPages();



        MyPageInfo<Comment> mypage=new MyPageInfo<>(list,pageNum,pageSize,totalPage);
        return mypage;

    }
}
