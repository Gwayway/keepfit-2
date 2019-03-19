package com.willbest.keepfit.config;

import com.willbest.keepfit.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Autowired
    LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/***")
                .excludePathPatterns("/cis/l1")
                .excludePathPatterns("/cis/l2")
                .excludePathPatterns("/cis/c1")
                .excludePathPatterns("/cis/c2");
    }
}
