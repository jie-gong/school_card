package com.gong.school_card.pccontroller;

import com.gong.school_card.TokenUtil.TokenProccessor;
import com.gong.school_card.TokenUtil.TokenTools;
import com.gong.school_card.mapper.AdminMapper;
import com.gong.school_card.mapper.StudentMapper;
import com.gong.school_card.mapper.UserMapper;
import com.gong.school_card.pojo.Admin;
import com.gong.school_card.pojo.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import io.netty.util.internal.ObjectUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pccontroller.LoginController
 * @Date: 2022年09月13日 10:01
 * @Description:      登录验证
 */
@RestController
public class LoginController {
    public static Integer SessionMaxInactiveInterval=30*60;
    public static final String PASS_WARD = "123456";
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    @PostMapping(value = "/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        @RequestParam("verifyCode") String verifyCode,
                        HttpSession session) {
        if (StringUtils.isEmpty(verifyCode)) {
            session.setAttribute("errorMsg", "验证码不能为空");
            return "admin/login";
        }
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            session.setAttribute("errorMsg", "用户名或密码不能为空");
            return "admin/login";
        }
        String kaptchaCode = session.getAttribute("verifyCode") + "";
        if (StringUtils.isEmpty(kaptchaCode) || !verifyCode.equals(kaptchaCode)) {
            session.setAttribute("errorMsg", "验证码错误");
            return "admin/login";
        }
//        Admin adminUser = adminMapper.login(userName, password);
//        System.out.println(adminUser);
//        if (adminUser != null) {
//            session.setAttribute("loginUser", adminUser.getNickName());
//            session.setAttribute("loginUserId", adminUser.getAdminUserId());
//            //session过期时间设置为7200秒 即两小时
//            //session.setMaxInactiveInterval(60 * 60 * 2);
//            return "redirect:/admin/index";
//        } else {
//            session.setAttribute("errorMsg", "登陆失败");
//            return "admin/login";
//        }
        return "redirect:/user/user";
    }


    //登录
    @RequestMapping("/user/login")
    public ModelAndView AdminLogin(String admin,
                                   String adminpass,
                                   Model model,
                                   HttpSession session,
                                   HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("admin", admin);
        objectObjectHashMap.put("adminpass", adminpass);
        List<Admin> admins = adminMapper.selectByMap(objectObjectHashMap);

        //获取缓存内数据
        Object admin1 = redisTemplate.opsForValue().get(admin);
        Object attribute = request.getSession().getAttribute("userLogin");
        System.out.println("聊了了聊了了了聊了了了了" + admin1 + attribute);
        /**
         * 判断Redis中的token是不是空
         * @notNull 返回登录界面 无法正常登录
         * @Null 正常登录 正常放行
         */
        if (admin1 != null && request.getSession().getAttribute("userLogin") == null) {
            session.setAttribute("admin", admin1);
            model.addAttribute("msg", "账号未下线，无法登录");
            modelAndView.setViewName("index");
        } else {
            if (admins.size() == 0) {
                model.addAttribute("msg", "用户名或密码错误");
                modelAndView.setViewName("index");
            } else {
                session.setAttribute("userLogin", admin);
//                session.setMaxInactiveInterval(-1);
                String s = TokenProccessor.makeToken(admin);
                long l = TimeUnit.MILLISECONDS.toMillis(30);
                redisTemplate.opsForValue().set(admin, s,l);
                session.setAttribute("admin", s);
                session.setMaxInactiveInterval(SessionMaxInactiveInterval);
                model.addAttribute("username", admin);
                modelAndView.addObject("admin", admins);
                modelAndView.setViewName("redirect:/user/user");
            }
        }

        return modelAndView;
    }

    //找回密码
    @RequestMapping("/retrieve/password")
    public ModelAndView Retrieve_Password(String username,
                                          Model model,
                                          HttpSession session) {
//        String password = "123456";
        ModelAndView modelAndView = new ModelAndView();
        //验证账号与密保
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("username", username);
        List<User> users1 = userMapper.selectByMap(stringObjectHashMap);
//        stringObjectHashMap.put("kay", kay);
//        List<User> users = userMapper.selectByMap(stringObjectHashMap);

        if (users1.size() == 0) {
            model.addAttribute("mssg", "用户不存在");
            modelAndView.setViewName("retrieve_password");
        }
//        else if (users.size() == 0) {
//            modelAndView.setViewName("retrieve_password");
//            model.addAttribute("mssg", "密保输入错误");
//        }
        else {
            //更新数据
            User user = new User();
            user.setUsername(username);
            user.setPassword(PASS_WARD);
            userMapper.user(user);
            System.out.println(username + PASS_WARD);
            model.addAttribute("msg", "验证成功将密码重置为" + PASS_WARD);
            modelAndView.setViewName("index");
            session.removeAttribute("loginUser");
        }
        return modelAndView;
    }

    //跳转管理员重置学生密码界面
    @RequestMapping("/user/use")
    public ModelAndView CurPassword(String admin,
                                    String adminpass,
                                    Model model,
                                    HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("admin", admin);
        objectObjectHashMap.put("adminpass", adminpass);
        List<Admin> admins = adminMapper.selectByMap(objectObjectHashMap);
        if (admins.size() == 0) {
            model.addAttribute("msg", "用户名或密码错误");
            modelAndView.setViewName("index02");
        } else {
            session.setAttribute("loginUser", admin);
            modelAndView.addObject("admin", admins);
            modelAndView.setViewName("retrieve_password");
        }
        return modelAndView;
    }

    @RequestMapping("/")
    public ModelAndView LoginRedis(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        /**
         *
         * 当前需要解决admin账户传输问题    √
         */
        Object admin = request.getSession().getAttribute("admin");
        if (admin == null & request.getSession().getAttribute("userLogin") == null) {
            System.out.println("删除所有key");
            /*
            删除所有key;
             */
            //获取所有key
//            Set keys = redisTemplate.keys("*");
//            Iterator<String> iterator = keys.iterator();
//            //通过while删除
//            while (iterator.hasNext()) {
//                redisTemplate.delete(iterator.next());
//            }
            modelAndView.setViewName("index");
        } else {
            modelAndView.setViewName("redirect:/user/user");
        }
        //废弃的方法
//        Object admin1 = redisTemplate.opsForValue().get(admin);
//        if (admin1 == null) {
//            session.setAttribute("admin", admin1);
//            modelAndView.setViewName("redirect:/clear/session");
//        } else {
//            modelAndView.setViewName("redirect:/user/user");
//        }
        return modelAndView;
    }

}
