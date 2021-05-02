package com.xyy.web.controller;

import com.xyy.utils.JsonInfo;
import org.apache.commons.fileupload.FileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * @author user
 * @date 2021/4/18 - 15:34
 */
@Controller
public class UploadController {

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

            String diskpath = disklocation + "/" + name;
            System.out.println(diskpath);
            File file = new File(diskpath);
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

}
