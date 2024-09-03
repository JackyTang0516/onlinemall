package com.hmall.order.interceptors;

import com.hmall.order.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.获取请求头
        String authorization = request.getHeader("authorization");
        if(StringUtils.isBlank(authorization)){
            log.warn("非法用户访问！请求路径：{}", request.getRequestURI() );
            // 没有用户信息，未登录 403 禁止
            response.setStatus(403);
            return false;
        }
        // 2.转换用户id
        Long userId = Long.valueOf(authorization);
        // 3.存入ThreadLocal
        UserHolder.setUser(userId);
        // 3.放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 用完不要忘了清理
        UserHolder.removeUser();
    }
}
