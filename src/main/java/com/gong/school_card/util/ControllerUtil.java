package com.gong.school_card.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.util.ControllerUtil
 * @Date: 2022年10月15日 13:01
 * @Description:
 */
@Service
public class ControllerUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    //判断是否异地登录
    public static Boolean GoOut(Object token, Object admin) {
        return token.equals(admin);
    }

    //异地登陆判断工具类
    public  Boolean LoginUtil(HttpServletRequest request) {
        Object admin = request.getSession().getAttribute("admin");
        Object userLogin = request.getSession().getAttribute("userLogin");
        Object o = redisTemplate.opsForValue().get(userLogin);
        Boolean aBoolean = ControllerUtil.GoOut(admin, o);
        return aBoolean;
    }

    //获取账号数据信息
    public void UserUtil(HttpServletRequest request) {
        Object admin = request.getSession().getAttribute("admin");
        Object userLogin = request.getSession().getAttribute("userLogin");
        Object o = redisTemplate.opsForValue().get(userLogin);
    }

}
