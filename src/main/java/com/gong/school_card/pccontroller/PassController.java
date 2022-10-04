package com.gong.school_card.pccontroller;

import com.gong.school_card.mapper.*;
import com.gong.school_card.pojo.Testlogin;
import com.gong.school_card.pojo.vo.UserAndStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pccontroller.PagerController
 * @Date: 2022年09月20日 10:32
 * @Description:
 */

@Controller
public class PassController {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TestLoginMapper testLoginMapper;


    @GetMapping("/getAllUser")
    public String AllS() {
        return "verifyPassword";
    }

    @RequestMapping("/verify/password")
    public ModelAndView verify(String test, Model model, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        HashMap<String, Object> objectStringHashMap = new HashMap<>();
        objectStringHashMap.put("test", test);
        List<Testlogin> testLogins = testLoginMapper.selectByMap(objectStringHashMap);
        if (testLogins.size() == 0) {
            model.addAttribute("msg", "管理员验证密码错误");
            modelAndView.setViewName("verifyPassword");
        } else {
            session.setAttribute("User", test);
            List<UserAndStudent> userAndStudents = userMapper.selectUser();
            model.addAttribute("pageInfo", userAndStudents);
            modelAndView.setViewName("StudentPass");
        }
        return modelAndView;
    }

    @PostMapping("/selecet/password")
    public String SP(String name, Model model) {
        List<UserAndStudent> userAndStudents = userMapper.selectUserByName(name);
        model.addAttribute("msg", userAndStudents);
        return "StudentPassList";
    }
}
