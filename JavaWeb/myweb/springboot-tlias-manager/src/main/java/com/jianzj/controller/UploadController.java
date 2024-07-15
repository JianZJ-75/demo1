package com.jianzj.controller;

import com.aliyuncs.exceptions.ClientException;
import com.jianzj.pojo.Result;
import com.jianzj.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/7/9 22:33
 */

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils ossUtils;

//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//        log.info("文件上传: {}, {}, {}", username, age, image);
//
//        String originName = image.getOriginalFilename();
//        String uuid = UUID.randomUUID().toString();
//        String extname = originName.substring(originName.lastIndexOf("."));
//
//        image.transferTo(new File("E:\\Git\\demo1\\JavaWeb\\myweb\\springboot-tlias\\src\\main\\resources\\img\\" + uuid + extname));
//
//        return Result.success();
//    }

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException, ClientException {
        log.info("文件上传: {}" + image.getOriginalFilename());
        // 调用阿里云OSS工具类进行文件上传
        String url = ossUtils.upload(image);
        log.info("文件上传完成, 文件访问的url: {}" + url);

        return Result.success(url);
    }

}