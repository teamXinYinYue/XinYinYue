package com.xyy.controller;

import com.xyy.po.Music;
import com.xyy.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author user
 * @date 2021/5/10 - 17:23
 */
@Controller
public class CookieController {
    @Autowired
    private MusicService musicService;

    @ResponseBody
    @RequestMapping("saveOneCookie")
    public String saveOneCookie(HttpServletRequest request) {
        Integer times;
        Integer mid;
        Integer hot;

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        //times.37=1; times.38=1
        String cookies= multipartRequest.getParameter("cookie").replace(" ","");
        if(cookies!=null){
            String[] splitted = cookies.split(";");
            for(String cookie:splitted){
                //times.37=1
                hot=0;
                mid=Integer.parseInt( cookie.substring(cookie.indexOf('.') + 1, cookie.lastIndexOf('=')));
                times=Integer.parseInt(cookie.substring(cookie.lastIndexOf('=')+1));


                Music music=new Music();
                music.setM_id(mid);

                List<Music> musicsByMC = musicService.findMusicByMC(mid);
                for (Music musicByMC:musicsByMC){
                    if(musicByMC.getHot()!=null){
                        hot=musicByMC.getHot();
                    }
                    break;
                }
                hot=hot+times;
                music.setHot(hot);
                musicService.updateMusic(music);
            }
        }
        return "ok";
    }
}