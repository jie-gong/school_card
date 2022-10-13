package com.gong.school_card.config;

import com.gong.school_card.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.config.LoginHandlerInterceptor
 * @Date: 2022年09月13日 14:28
 * @Description:
 */

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object admin = request.getSession().getAttribute("admin");
        //登陆成功之后验证Token
//        Object admin = redisTemplate.opsForValue().get("admin");
//        System.out.println("sssssss=========================" + admin);
        if (admin == null) {
            request.setAttribute("msg", "没有权限请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
}
