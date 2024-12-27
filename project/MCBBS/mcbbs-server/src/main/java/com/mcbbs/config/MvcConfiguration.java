package com.mcbbs.config;

import com.mcbbs.interceptor.AdminInterceptor;
import com.mcbbs.interceptor.JwtInterceptor;
import com.mcbbs.json.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/14 17:36
 */

@Configuration
@Slf4j
public class MvcConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private JwtInterceptor jwtInterceptor;
    @Autowired
    private AdminInterceptor addInterceptors;

    /**
     * 注册自定义拦截器
     * @param registry
     */
    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义拦截器...");
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/user/**")
                .excludePathPatterns("/user/user/login")
                .excludePathPatterns("/user/user/register");
        registry.addInterceptor(addInterceptors)
                .addPathPatterns("/admin/**");
    }

    /**
     * 扩展Spring MVC框架的消息转化器
     * @param converters
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        log.info("扩展消息转换器...");
        // 创建一个消息转换器对象
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // 需要为消息转换器设置一个对象转换器, 对象转换器可以将Java对象序列化为json数据
        converter.setObjectMapper(new JacksonObjectMapper());
        // 将自己的消息转换器加入容器中
        converters.add(0, converter);
    }

}