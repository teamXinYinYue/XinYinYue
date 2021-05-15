package com.xyy.web.controller;

import com.xyy.po.Music;
import com.xyy.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        String cookieName;
        Integer mid;
        Integer hot;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().contains("times")){
                hot=0;
                cookieName=cookie.getName();
                times=Integer.parseInt(cookie.getValue());
                mid=Integer.parseInt(cookieName.substring(cookieName.lastIndexOf(".")+1));


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