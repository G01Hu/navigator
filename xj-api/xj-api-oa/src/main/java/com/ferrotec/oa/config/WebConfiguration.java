package com.ferrotec.oa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @Description: 使用Gson作为json转换工具
 * @Author: huqy
 * @Date: 2020/2/20
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        // 删除MappingJackson2HttpMessageConverter
        converters.removeIf(httpMessageConverter -> httpMessageConverter instanceof MappingJackson2HttpMessageConverter);
        // 添加GsonHttpMessageConverter
        converters.add(new GsonHttpMessageConverter());
    }
}
