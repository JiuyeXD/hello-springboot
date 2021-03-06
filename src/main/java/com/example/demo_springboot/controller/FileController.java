package com.example.demo_springboot.controller;

import com.example.demo_springboot.domain.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/*
 * @author: Jiuye
 * @date: 2020-07-16 16:19
 * @package: com.example.demo_springboot.controller
 * @Description: 头像文件上传
 */
@Controller
@PropertySource({"classpath:static/config/upload.properties"})

public class FileController {
    //主页
    @RequestMapping(value = "/")
    public Object Index(){
        return "index";
    }
    //文件目录
    //注意 : 结尾一定要加 "/" 要不然会导致上传后的文件路径不正确 导致异常错误!
    //private static final String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\";
    @Value("${web.file.path}")
    private String filePath;


    @RequestMapping("/upload")
    @ResponseBody
    public JsonData uoload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request){

        System.out.println("配置注入打印 : " + filePath);

        if(file.isEmpty()){
            return new JsonData(-1,"file is Empty");
        }/*else if(file.getSize() > 10240000){
            return new JsonData(-1,"file too hurge");
        }*/
        //获取用户名
        String name = request.getParameter("user_name");
        System.out.println("用户名 : " + name);

        //获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("文件名 : " + fileName);

        //获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("后缀名 : " + suffixName);

        //文件上传后的路径
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);

        try {
            file.transferTo(dest);
            return new JsonData(0,fileName,"success");
        }catch (IllegalStateException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JsonData(-1,"failed to upload");
    }
}
