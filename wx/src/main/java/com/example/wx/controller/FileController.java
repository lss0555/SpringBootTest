package com.example.wx.controller;

import com.example.wx.model.TResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Description 微信文件上传测试
 * @Author lss0555
 * @Date 2019/3/28/028 15:08
 **/
@Controller
public class FileController  {
    @Value("${FILE_ROOT}")
    private String FILE_ROOT;


    @GetMapping("/upload")
    public String uploadFile(){
        return "uploadFile";
    }

    /**
     * @Description  上传文件
     **/
    @PostMapping("/uploadFile")
    @ResponseBody
    @CrossOrigin
    public TResult uploadFile(@RequestParam("file") MultipartFile from_file) throws FileNotFoundException {
        TResult result = new TResult();
        File file = new File(ResourceUtils.getURL("classpath:").getPath());
        String uploadUrl = file.getAbsolutePath() + FILE_ROOT;
        //文件原名
//        String filename = java.util.UUID.randomUUID().toString();
        String filename=from_file.getOriginalFilename();
        String pic_type = from_file.getContentType();
        System.out.println(pic_type);

        File dir = new File(uploadUrl);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        System.out.println("文件上传到: " + uploadUrl + filename);
        File targetFile = new File(uploadUrl + filename);
        if (!targetFile.exists()) {
            try {
                targetFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            from_file.transferTo(targetFile);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        result.setStringData(filename);
        return result;
    }
}
