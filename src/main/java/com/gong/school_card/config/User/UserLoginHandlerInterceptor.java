package com.gong.school_card.config.User;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.config.User.UserLoginHandlerInterceptor
 * @Date: 2022年09月20日 17:20
 * @Description:
 */
public class UserLoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆成功之后验证session
        Object User = request.getSession().getAttribute("User");
        if (User == null) {
            request.setAttribute("msg", "没有高级权限");
            request.getRequestDispatcher("/verifyPassword.html").forward(request, response);
            return false;
        } else {
            return true;
        }

    }

}
