//package com.shanzhu.tourism.config;
//
//import com.shanzhu.tourism.interceptor.TokenInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * springMvc web配置
// */
//@Configuration
//public class WebConfig extends WebMvcConfigurerAdapter {
//
//    @Autowired
//    private TokenInterceptor tokenInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor)
//                //拦截所有请求
//                .addPathPatterns("/**")
//                //排除请求
//                .excludePathPatterns("/file/**","/video/**","/img/**","/login","/common/**","/user/setUserAvatar/**"
//                        ,"/user/getEmailReg/**","/user/forgetPassword/**","/user/saveUser/**");
//    }
//}
package com.shanzhu.tourism.config;

import com.shanzhu.tourism.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                // 拦截所有请求
                .addPathPatterns("/**")
                // 排除请求
                .excludePathPatterns("/file/**", "/video/**", "/img/**", "/login", "/common/**", "/user/setUserAvatar/**"
                        , "/user/getEmailReg/**", "/user/forgetPassword/**", "/user/saveUser/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许跨域访问的路径
                .allowedOrigins("*") // 允许所有来源
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的请求方法
                .allowedHeaders("*") // 允许的请求头
                .allowCredentials(true); // 是否允许发送Cookie
    }
}