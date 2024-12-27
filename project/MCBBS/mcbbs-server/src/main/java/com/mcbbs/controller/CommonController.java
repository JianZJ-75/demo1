package com.mcbbs.controller;

import com.mcbbs.constant.MessageConstant;
import com.mcbbs.result.Result;
import com.mcbbs.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @Author JianZJ
 * @Date 2024/11/23 16:58
 */

@RestController
@Slf4j
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    /**
     * 上传文件
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上传: {}", file);
        try {
            // 原始文件名
            String originalFilename = file.getOriginalFilename();
            // 文件扩展名
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 新文件名称
            String objectName = UUID.randomUUID().toString() + extension;
            String url = aliOssUtil.upload(file.getBytes(), objectName);
            return Result.success(url);
        } catch (Exception e) {
            log.info("文件上传失败: {}", e);
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }

}
