package com.gong.school_card.pccontroller;

import com.gong.school_card.TokenUtil.TokenProccessor;
import com.gong.school_card.TokenUtil.TokenTools;
import com.gong.school_card.pojo.Admin;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pccontroller.CurController
 * @Date: 2022年09月13日 10:18
 * @Description:
 */
@Controller
public class CurController {
    @Autowired
    private ControllerUtil controllerUtil;

    //跳转学生登录界面

    @GetMapping("/student")
    public String goStudent() {
        return "studentlogin";
    }

    //跳转管理员登录界面
    @GetMapping("/Admin")
    public String goAdmin() {
        return "index";
    }

    //跳转找回密码页面
    @GetMapping("/retrieve")
    public String goRetrieve() {
        return "index02";
    }


    @Autowired
    private RedisTemplate redisTemplate;


    //退出登录 清除Token
    @GetMapping("/clear/Token")
    public String ClearToken(HttpSession session, Admin admin) {
        //清除session
        session.removeAttribute("admin");
        //清除token
        Set keys = redisTemplate.keys("*");
        if (ObjectUtils.isEmpty(keys)) {
            redisTemplate.delete(keys);
        }
        return "index";
    }

    //推出登录 清除TOKEN
    @GetMapping("/clear/session")
    public String ClearSession(HttpSession session) {
        //清除TOKEN
        Set keys = redisTemplate.keys("*");
        if (ObjectUtils.isEmpty(keys)) {
            redisTemplate.delete(keys);
        }
        session.removeAttribute("admin");
        return "index";
    }


    //    //跳转学生管理界面
//    @GetMapping("/touserlist")
//    public String userList(){
//        return "userlist";
//    }
//
//学生登录
    @GetMapping("/studentlogin/login")
    public String StudentLogin(Model model) {
        //msg 返回通知
        model.addAttribute("msg", "网页学生版暂未开放，请移步app");
        return "studentlogin";
    }

    //跳转查询学生充值记录界面
//    @GetMapping("/recharge/record")
//    public String recharge() {
//        return "recharge_record";
//    }


    //跳转主页管理界面
    @GetMapping("/user/user")
    public String CurUser(HttpServletRequest request,Model model) {
        Boolean aBoolean = controllerUtil.LoginUtil(request);
        if (!aBoolean) {
            model.addAttribute("msg", "账号异地登陆，请确认账号密码安全");
            return "index";
        } else {
            return "dashboard";
        }
    }

    //跳转注册学生界面
    @GetMapping("/user/getStudent")
    public String useraddStudent() {
        return "/emp/addStudent";
    }

    //跳转发送公告页面
    @GetMapping("/CurGG")
    public String CurGG() {
        return "GG";
    }

}
