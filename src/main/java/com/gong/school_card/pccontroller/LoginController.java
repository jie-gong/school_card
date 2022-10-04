package com.gong.school_card.pccontroller;

import com.gong.school_card.mapper.AdminMapper;
import com.gong.school_card.mapper.StudentMapper;
import com.gong.school_card.mapper.UserMapper;
import com.gong.school_card.pojo.Admin;
import com.gong.school_card.pojo.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pccontroller.LoginController
 * @Date: 2022年09月13日 10:01
 * @Description:
 */
@RestController
public class LoginController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping("/user/login")
    public ModelAndView AdminLogin(String admin,
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
            modelAndView.setViewName("index");
        } else {
            session.setAttribute("loginUser", admin);
            model.addAttribute("username", admin);
            modelAndView.addObject("admin", admins);
            modelAndView.setViewName("/dashboard.html");
        }

        return modelAndView;
    }

    //找回密码
    @RequestMapping("/retrieve/password")
    public ModelAndView Retrieve_Password(String username,
                                          String kay,
                                          Model model,
                                          HttpSession session) {
        String password = "123456";
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
            user.setPassword("123456");
            userMapper.user(user);
            System.out.println(username + password);
            model.addAttribute("msg", "验证成功将密码重置为123456");
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

}
