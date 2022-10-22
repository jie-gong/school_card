package com.gong.school_card.pccontroller;

import com.gong.school_card.mapper.AnnouncementMapper;
import com.gong.school_card.pojo.Announcement;
import com.gong.school_card.pojo.Student;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pccontroller.AnnouncementController
 * @Date: 2022年10月20日 11:48
 * @Description:
 */
@Controller
public class AnnouncementController {

    @Resource
    private AnnouncementMapper announcementMapper;


    //跳转到发布公告界面
    @GetMapping("/ToStudent/{studentid}")
    public String ToStudent(Model model, @PathVariable int studentid) {
        Student itme = announcementMapper.SelectStudentName(studentid);
        model.addAttribute("msg02", "将公告发送给" + itme.getName());
        System.out.println(itme);
        Integer studentid1 = itme.getStudentid();
        model.addAttribute("item", studentid1);
        return "GG/GG02";
    }


    //给某一位同学发送公告（消息），私信
    @PostMapping("/getTipToStudent")
    public String NewsToStudent(Announcement announcement, Model model) {
        announcementMapper.insert(announcement);
        model.addAttribute("msg02", "通知成功");
        return "GG/GG02";
    }
}
