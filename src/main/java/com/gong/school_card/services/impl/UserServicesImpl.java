package com.gong.school_card.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gong.school_card.TokenUtil.TokenProccessor;
import com.gong.school_card.mapper.UserMapper;
import com.gong.school_card.pojo.User;
import com.gong.school_card.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.services.impl.UserSercvicesImpl
 * @Date: 2022年10月12日 15:22
 * @Description:
 */
@Service
public class UserServicesImpl extends ServiceImpl<UserMapper, User> implements UserServices {

    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    //账号登录
    public Object Login(User user) {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        String username = user.getUsername();
        String password = user.getPassword();
        objectObjectHashMap.put("username", username);
        objectObjectHashMap.put("password", password);
        List<User> users = userMapper.selectByMap(objectObjectHashMap);
        return users;
    }

    //学生登陆生成token
    public String GetToken(String username) {
        String s = TokenProccessor.makeToken(username);
        redisTemplate.opsForValue().set(username, s, 24, TimeUnit.HOURS);
        return s;
    }

    //查询redis缓存数据
    public int GetToken01(User user) {
        Object o = redisTemplate.opsForValue().get(user.getUsername());
        if (o == null) {
            return 0;
        } else {
            return 1;
        }
    }
}
