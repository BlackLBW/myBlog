package com.bowen.blog.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by libowen on 2018/9/4.
 * 登录注解
 */

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface LoginRequired {
}
