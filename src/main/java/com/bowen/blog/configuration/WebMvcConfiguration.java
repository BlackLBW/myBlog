package com.bowen.blog.configuration;

import com.bowen.blog.filter.CrosFilter;
import com.bowen.blog.interceptor.AuthenticationInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * 拦截器过滤器注册类
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/");
        super.addInterceptors(registry);
    }

    @Bean
    public FilterRegistrationBean registCrosFilter() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        List<String> urls = new ArrayList<>();
        urls.add("/*");
        filterRegistrationBean.setUrlPatterns(urls);
        filterRegistrationBean.setFilter(new CrosFilter());

        return filterRegistrationBean;
    }

}
