package com.bowen.blog.interceptor;

import com.bowen.blog.annotations.LoginRequired;
import com.bowen.blog.biz.UserBiz;
import com.bowen.blog.model.Result;
import com.bowen.blog.model.User;
import com.bowen.blog.util.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by libowen on 2018/9/4.
 * 认证拦截器
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserBiz userBiz;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        LoginRequired annotation = method.getAnnotation(LoginRequired.class);
        if (annotation != null) {

            // session先取下userName
            String userName = request.getParameter("userName");
            if (StringUtils.isBlank(userName)) {
                response.setContentType("application/json; charset=UTF-8");
                response.getWriter()
                        .write(JsonUtils.toJsonStr(Result.notLogin()));
                return false;
            }

            String userNameFromSession = String.valueOf(request.getSession().getAttribute("userName"));
            if (StringUtils.isNotBlank(userNameFromSession) && userNameFromSession.equals(userName)) {
                return true;
            }

            String password = request.getParameter("password");
            if (StringUtils.isNotBlank(password)) {
                User user = userBiz.getUserByName(userName);
                if (user != null && user.getPassword().equals(password)) {
                    return true;
                }
            }

            response.setContentType("application/json; charset=UTF-8");
            response.getWriter()
                    .write(JsonUtils.toJsonStr(Result.notLogin()));
            return false;
        }

        return true;
    }

}
