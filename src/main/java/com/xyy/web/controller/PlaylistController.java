package com.xyy.web.controller;

import com.xyy.po.Playlist;
import com.xyy.po.User;
import com.xyy.service.PlaylistService;
import com.xyy.utils.JsonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @ResponseBody
    @RequestMapping(value = "/findPlaylist",method = RequestMethod.POST)
    public JsonInfo findPlaylist(@RequestBody User user) {

        JsonInfo jsonInfo=new JsonInfo();

        List<Playlist> list=playlistService.findPlaylist(user.getU_id());

        if( list.size()!=0) {

            jsonInfo.setObj(list);

            return jsonInfo;
        }
        jsonInfo.setMsg("查找失败");

        return jsonInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/addPlaylist",method = RequestMethod.POST)
    public JsonInfo addPlaylist(@RequestBody List<Playlist> playlists) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=playlistService.insertPlaylist(playlists);

        if(rows<=0) {

            jsonInfo.setMsg("歌单添加失败，请重试！");

        }else{

            jsonInfo.setMsg("歌单添加成功");
        }

        return jsonInfo;
    }


    @ResponseBody
    @RequestMapping(value = "/deletePlaylist",method = RequestMethod.POST)
    public JsonInfo deletePlaylist(@RequestBody List<Playlist> playlists) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=playlistService.deletePlaylist(playlists);

        if(rows>0) {

            jsonInfo.setMsg("歌单删除成功");

        } else {

            jsonInfo.setMsg("歌单删除失败，请重试！");

        }

        return jsonInfo;
    }


    @ResponseBody
    @RequestMapping(value = "/updatePlaylist",method = RequestMethod.POST)
    public JsonInfo updatePlaylist(@RequestBody Playlist playlist) {

        JsonInfo jsonInfo=new JsonInfo();

        int rows=playlistService.updatePlaylist(playlist);

        if(rows>0) {

            jsonInfo.setMsg("歌单更新成功");

        } else {

            jsonInfo.setMsg("歌单更新失败，请重试！");

        }

        return jsonInfo;
    }
}
