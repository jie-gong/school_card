package com.gong.school_card.phonecontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gong.school_card.TokenUtil.TokenProccessor;
import com.gong.school_card.mapper.UserMapper;
import com.gong.school_card.pojo.User;
import com.gong.school_card.returnjson.LoginObject;
import com.gong.school_card.returnjson.ReturnObject;
import com.gong.school_card.services.impl.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.phonecontroller.LoginSorU
 * @Date: 2022年10月12日 15:11
 * @Description:
 */
@RestController
@RequestMapping("/login")
public class LoginSorU {
    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    private UserServicesImpl services;

    //学生登录
    //请求token
    @PostMapping("/studentLogin")
    public Object SLogin(@RequestBody User user) {
        //账号密码登录
        List<User> login = (List<User>) services.Login(user);
        if (login.size() == 0) {
            return JSONObject.toJSON(new ReturnObject(500, "账号密码错误"));
        } else {
            String s = services.GetToken(user.getUsername());
            return JSONObject.toJSON(new LoginObject(200, "登陆成功", s));
        }
    }

    //验证有无token 没有token退出登录
    @PostMapping("/verify")
    public Object verify(@RequestBody User user) {
        int i = services.GetToken01(user);
        if (i == 0) {
            return JSONObject.toJSON(new ReturnObject(404, "没有Token，请重新登录"));
        } else {
            System.out.println("执行成功");
            return JSONObject.toJSON(new ReturnObject(200, "Token状态正常"));
        }
    }
}
