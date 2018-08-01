package com.eakay.next.web.config;

import com.eakay.next.web.filter.LogFilter;
import com.eakay.next.web.interceptor.AccessHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.Filter;

/**
 * Created by 张亚鹏 on 2018/7/8.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    AccessHandlerInterceptor accessHandlerInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(accessHandlerInterceptor);
        interceptorRegistration.excludePathPatterns("/druid/**");

        super.addInterceptors(registry);
    }

    @Bean
    public LogFilter logFilter() {
        return new LogFilter();
    }

    @Bean
    public FilterRegistrationBean logFilter4RegistrationBean() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(logFilter());
        registration.addUrlPatterns("/*");
        registration.setName("LogFilter");
        return registration;
    }

}
