package com.ttg.service.notice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>Title: WebAppConfig</p>
 * <p>Description: </p>
 *  解决跨域问题（协议、IP、端口三者保持统一才能确定统一域）
 * @Author yangtao
 * @Date 2018/9/19 11:03
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  //过滤所有路径
                .allowedOrigins("*") //过滤域 http:www.biadu.com||127.0.0.1:8080
                .allowedMethods("*") //过滤http请求方法：GET,POST,PUT,PATCH,DELETE
                .allowedHeaders("*");
    }
}
