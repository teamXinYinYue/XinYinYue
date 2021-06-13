package com.xyy.controller;

import com.xyy.po.Location;
import com.xyy.po.Music;
import com.xyy.po.Singer;
import com.xyy.service.LocationService;
import com.xyy.service.MusicCategoryService;
import com.xyy.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

@Controller
public class UploadController {

    @Autowired
    private MusicService musicService;

    @Autowired
    private MusicCategoryService musicCategoryService;

    @Autowired
    private LocationService locationService;

    @ResponseBody
    @RequestMapping(value = "uploadOnePictureFileByformdata",method = RequestMethod.POST)
    public HashMap uploadOnePictureFileByformdata(HttpServletRequest request) {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile=multipartRequest.getFile("file");

        String name = multipartFile.getOriginalFilename();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String prefix = sdf.format(new Date());

        Random r = new Random();

        for(int i =0 ;i<3;i++){
            prefix=prefix+r.nextInt(10);
        }
        name=prefix+name;

//        String disklocation = request.getSession().getServletContext().getRealPath("/picture");

        String disklocation = "/usr/MyUpload/picture/";

        String diskpath_file = disklocation+"/" + name;
        String diskpath_dir=disklocation+"/";

        File dir=new File(diskpath_dir);
        if(!dir.exists()){
            dir.mkdirs();
        }

        File file = new File(diskpath_file);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String path=request.getContextPath()+"/picture/"+ name;

        Location location=new Location();
        location.setS_id(Integer.parseInt(multipartRequest.getParameter("sid")));
        String i_info=multipartRequest.getParameter("iinfo");
        location.setI_info(i_info);
        location.setI_path(path);
        locationService.insertLocation(location);

        HashMap hashMap=new HashMap();
        hashMap.put("msg",true);
        hashMap.put("path",path);
        return hashMap;

    }



    @ResponseBody
    @RequestMapping(value = "uploadOneMusicByFormData",method = RequestMethod.POST)
    public HashMap uploadOneMusicByFormData(HttpSession session,HttpServletRequest request  , RedirectAttributes redirectAttrs) {


        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile=multipartRequest.getFile("file");

        String cname= multipartRequest.getParameter("cname");
        String mname= multipartRequest.getParameter("mname");

        Integer cid = musicCategoryService.findMusicCategoryIDbyName(cname);

        Music music =  new Music();
        music.setM_name(mname);
        music.setCa_id(cid);
        Singer singer = (Singer) session.getAttribute("singer");
        if( singer!=null){
            music.setS_id(singer.getS_id());
        }else{
            music.setS_id(Integer.parseInt(multipartRequest.getParameter("sid2")));
        }


        HashMap hashMap=new HashMap();

        music.setPriority(1);
        music.setHot(0);
        music.setMdate(new Date());
        Integer m_id=musicService.insertMusic(music);
        if(m_id==null) {

            hashMap.put("msg",false);
            return hashMap;

        }

//        String disklocation = request.getSession().getServletContext().getRealPath("/music");

        String disklocation = "/usr/MyUpload/music/";

        String diskpath_file = disklocation+"/" + cname + "/" + m_id;
        String diskpath_dir=disklocation+"/" + cname;

        File dir=new File(diskpath_dir);
        if(!dir.exists()){
            dir.mkdirs();
        }

        File file = new File(diskpath_file);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String path=request.getContextPath()+"/music/" + cname + "/"+ m_id;

        music.setPath(path);
        if(musicService.updateMusic(music)!=0){
            hashMap.put("msg",true);
            hashMap.put("mid",m_id);
            hashMap.put("path",path);
        }else{
            hashMap.put("msg",false);
            return hashMap;
        }


        return hashMap;
    }




    //      //测试代码
//        Integer cid=1;
//        String mname="2";
//        music.setM_name(mname);
//        music.setCa_id(cid);
//        music.setS_id(1);

    //        //使用原始名
//        String fileName = multipartFile.getOriginalFilename();
//        //添加后缀名
//        String name = mname+fileName.substring(fileName.lastIndexOf("."));


    //      //重定向方式处理
//        redirectAttrs.addFlashAttribute("music", music);
//
//        JsonInfo jsonInfo=new JsonInfo();
//        jsonInfo.setObj(path);
//        redirectAttrs.addFlashAttribute("jsonInfo", jsonInfo);
//        return "redirect:addMusic";


//     //CommonsMultipartFile方式处理请求
    //    @ResponseBody
//    @RequestMapping("uploadOnePicByformdata")
//    public JsonInfo uploadOnePicByformdata(@RequestParam(name = "file",required = false) CommonsMultipartFile cmf, HttpServletRequest req){
//        JsonInfo jsonInfo=new JsonInfo();
//        FileItem fi=cmf.getFileItem();
//        String disklocation = req.getSession().getServletContext().getRealPath("/picture");
//        if (!fi.isFormField()) {
//            String name = fi.getName();
//
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//            String prefix = sdf.format(new Date());
//
//            Random r = new Random();
//
//            for(int i =0 ;i<3;i++){
//                prefix=prefix+r.nextInt(10);
//            }
//            name=prefix+name;
//
//            String diskpath_file = disklocation + "/" + name;
//            System.out.println(diskpath_file);
//
//            File dir=new File(disklocation);
//            if(!dir.exists()){
//                dir.mkdir();
//            }
//
//            File file = new File(diskpath_file);
//            try {
//                fi.write(file);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            String path=req.getContextPath()+"/picture/"+name;
//            System.out.println(path);
//            jsonInfo.setMsg("上传成功！");
//            jsonInfo.setObj(path);
//            return jsonInfo;
//        }
//        jsonInfo.setMsg("上传异常！请重试");
//
//        return jsonInfo;
//    }

}
