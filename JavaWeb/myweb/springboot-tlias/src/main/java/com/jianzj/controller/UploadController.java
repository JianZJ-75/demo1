package com.jianzj.controller;

import com.jianzj.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author JianZJ
 * @Date 2024/7/9 22:33
 */

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传: {}, {}, {}", username, age, image);

        String originName = image.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extname = originName.substring(originName.lastIndexOf("."));

        image.transferTo(new File("E:\\Git\\demo1\\JavaWeb\\myweb\\springboot-tlias\\src\\main\\resources\\img\\" + uuid + extname));

        return Result.success();
    }
}