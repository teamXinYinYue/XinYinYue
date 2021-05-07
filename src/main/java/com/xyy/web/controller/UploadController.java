package com.xyy.web.controller;

import com.xyy.po.Music;
import com.xyy.service.MusicCategoryService;
import com.xyy.utils.JsonInfo;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * @author user
 * @date 2021/4/18 - 15:34
 */
@Controller
public class UploadController {

    @Autowired
    private MusicCategoryService musicCategoryService;

    @ResponseBody
    @RequestMapping("uploadPic")
    public JsonInfo uploadPic(@RequestParam(name = "file",required = false) CommonsMultipartFile cmf, HttpServletRequest req){
        JsonInfo jsonInfo=new JsonInfo();
        FileItem fi=cmf.getFileItem();
        String disklocation = req.getSession().getServletContext().getRealPath("/picture");
        if (!fi.isFormField()) {
            String name = fi.getName();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String prefix = sdf.format(new Date());

            Random r = new Random();

            for(int i =0 ;i<3;i++){
                prefix=prefix+r.nextInt(10);
            }
            name=prefix+name;

            String diskpath_file = disklocation + "/" + name;
            System.out.println(diskpath_file);

            File dir=new File(disklocation);
            if(!dir.exists()){
                dir.mkdir();
            }

            File file = new File(diskpath_file);
            try {
                fi.write(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String path=req.getContextPath()+"/picture/"+name;
            System.out.println(path);
            jsonInfo.setMsg("上传成功！");
            jsonInfo.setObj(path);
            return jsonInfo;
        }
        jsonInfo.setMsg("上传异常！请重试");

        return jsonInfo;
    }


    @RequestMapping("uploadMus")
    public String uploadMus(HttpServletRequest request  ,RedirectAttributes redirectAttrs) {


        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile=multipartRequest.getFile("file");


//        Integer cid=Integer.parseInt(multipartRequest.getParameter("cid"));
//        String mname=multipartRequest.getParameter("mname");
        Integer cid=1;
        String mname="2";
        Music music =  new Music();
//        music.setM_name(mname);
//        music.setCa_id(cid);
//        music.setS_id(Integer.parseInt(multipartRequest.getParameter("sid")));
        music.setM_name(mname);
        music.setCa_id(cid);
        music.setS_id(1);

        music.setPriority(1);
        music.setHot(0);
        music.setMdate(new java.util.Date());


        String cname = musicCategoryService.findMusicCategoryNamebyID(cid);

        String fileName = multipartFile.getOriginalFilename();

        String name = mname+fileName.substring(fileName.lastIndexOf("."));
        String disklocation = request.getSession().getServletContext().getRealPath("/music");


        String diskpath_file = disklocation+"/" + cname + "/" + name;
        String diskpath_dir=disklocation+"/" + cname;

        System.out.println(diskpath_file);

        File dir=new File(diskpath_dir);
        if(!dir.exists()){
            dir.mkdir();
        }

        File file = new File(diskpath_file);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String path=request.getContextPath()+"/music/" + cname + "/"+ name;
        System.out.println(path);

        redirectAttrs.addFlashAttribute("music", music);

        JsonInfo jsonInfo=new JsonInfo();
        jsonInfo.setObj(path);
        redirectAttrs.addFlashAttribute("jsonInfo", jsonInfo);
        return "redirect:addMusic";

    }



}
