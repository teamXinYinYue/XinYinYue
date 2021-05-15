package com.xyy.web.controller;

import com.xyy.po.Playlist;
import com.xyy.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;


@Controller
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @ResponseBody
    @RequestMapping(value = "/findManyPlaylistByuid" )
    public HashMap findManyPlaylistByuid(Integer uid) {

        HashMap hashMap=new HashMap();

        List<Playlist> list=playlistService.findPlaylist(uid);

        if( list.size()!=0) {

            hashMap.put("playlistlist",list);

            return hashMap;
        }
        hashMap.put("msg","查找失败");
        return hashMap;
    }

    @ResponseBody
    @RequestMapping(value = "/addOnePlaylistByplaylist",method = RequestMethod.POST)
    public HashMap addOnePlaylistByplaylist(Playlist playlist) {

        HashMap hashMap=new HashMap();

        int rows=playlistService.insertPlaylist(playlist);

        if(rows<=0) {
            hashMap.put("msg","歌单添加失败，请重试！");

        }else{
            hashMap.put("msg","歌单添加成功");
        }

        return hashMap;
    }


    @ResponseBody
    @RequestMapping(value = "/deleteOnePlaylistBypnameuid",method = RequestMethod.POST)
    public HashMap deleteOnePlaylistBypnameuid(String pname,Integer uid) {

        HashMap hashMap=new HashMap();

        int rows=playlistService.deletePlaylist(pname,uid);

        if(rows>0) {
            hashMap.put("msg","歌单删除成功");

        } else {
            hashMap.put("msg","歌单删除失败，请重试！");

        }

        return hashMap;
    }


    @ResponseBody
    @RequestMapping(value = "/updateOnePlaylistByplaylist",method = RequestMethod.POST)
    public HashMap updateOnePlaylistByplaylist(@RequestBody Playlist playlist) {

        HashMap hashMap=new HashMap();

        int rows=playlistService.updatePlaylist(playlist);

        if(rows>0) {
            hashMap.put("msg","歌单更新成功");

        } else {
            hashMap.put("msg","歌单更新失败，请重试！");

        }

        return hashMap;
    }

}
