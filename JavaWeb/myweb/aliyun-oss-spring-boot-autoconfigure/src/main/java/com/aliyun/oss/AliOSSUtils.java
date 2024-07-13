package com.aliyun.oss;

import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @Author JianZJ
 * @Date 2024/7/10 2:21
 */

public class AliOSSUtils {

    private AliOSSProperties aliOSSProperties;

    public AliOSSProperties getAliOSSProperties() {
        return aliOSSProperties;
    }

    public void setAliOSSProperties(AliOSSProperties aliOSSProperties) {
        this.aliOSSProperties = aliOSSProperties;
    }

    /**
     * 实现文件上传到OSS
     * @param file
     * @return
     * @throws IOException
     */
    public String upload(MultipartFile file) throws IOException, ClientException {
        String endpoint = aliOSSProperties.getEndpoint();
        String bucketName = aliOSSProperties.getBucketName();
        // 获取文件的输入流
        InputStream inputStream = file.getInputStream();
        // 获取文件的原始文件名
        String originName = file.getOriginalFilename();
        // 获取OSS中存储的文件名
        String objectName = UUID.randomUUID().toString() + originName.substring(originName.lastIndexOf("."));
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        // 创建PutObject请求。
        ossClient.putObject(bucketName, objectName, inputStream);
        // 获取OSS中文件的地址
        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + objectName;
        ossClient.shutdown();
        // 把上传到oss的路径返回
        return url;
    }

}