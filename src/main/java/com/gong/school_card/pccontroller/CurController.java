package com.gong.school_card.pccontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pccontroller.CurController
 * @Date: 2022年09月13日 10:18
 * @Description:
 */
@Controller
public class CurController {
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

    //推出登录 清除session
    @GetMapping("/clear/session")
    public String ClearSession(HttpSession session) {
        //清除session
        session.removeAttribute("loginUser");
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
    public String CurUser() {
        return "dashboard";
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
