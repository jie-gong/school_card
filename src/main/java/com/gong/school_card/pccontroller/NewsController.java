package com.gong.school_card.pccontroller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gong.school_card.mapper.AnnouncementMapper;
import com.gong.school_card.pojo.Announcement;
import com.gong.school_card.pojo.vo.AnnouncementAndStudent;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pccontroller.NewsCOntroller
 * @Date: 2022年10月21日 08:42
 * @Description:
 */
@Controller
public class NewsController {

    @Autowired
    private AnnouncementMapper mapper;

    //跳转到消息发送界面并显示十条记录
    @GetMapping("/showNews/{studentid}")
    public ModelAndView ShowNews(Model model, @PathVariable("studentid") Integer studentid,
                                 @RequestParam(defaultValue = "1",
                                   value = "pageNum") long pageNum) {
        ModelAndView modelAndView = new ModelAndView();
        IPage<AnnouncementAndStudent> iPage = mapper.listNewsDesc(new Page<>(pageNum, 10), studentid);
        modelAndView.addObject("pageInfo", new Page<>(pageNum, 10));
        modelAndView.addObject("item", iPage.getRecords());
        modelAndView.addObject("item2", studentid);
        modelAndView.setViewName("news");
        return modelAndView;
    }


    //时间降序排列消息
    @GetMapping("/timedown/{studentid}")
    public String TimeDown(Model model, @PathVariable("studentid") Integer studentid,
                           @RequestParam(defaultValue = "1",
                                   value = "pageNum") long pageNum) {
        System.out.println(studentid);
//        int id = Integer.parseInt(studentid);
        IPage<AnnouncementAndStudent> iPage = mapper.listNewsDesc(new Page<>(pageNum, 10), studentid);
        model.addAttribute("pageInfo", new Page<>(pageNum, 10));
        model.addAttribute("item", iPage.getRecords());
//        int studentid1 = iPage.getRecords().get(0).getStudentid();
        model.addAttribute("item2", iPage.getRecords().get(0).getStudentid());
        return "news";
    }

    //时间升序排列消息
    @GetMapping("/timeup/{studentid}")
    public String TimeUp(Model model, @PathVariable("studentid") Integer studentid,
                         @RequestParam(defaultValue = "1",
                                 value = "pageNum") long pageNum) {
//        int id = Integer.parseInt(studentid);
        IPage<AnnouncementAndStudent> iPage = mapper.listNewsEsc(new Page<>(pageNum, 10), studentid);
        model.addAttribute("pageInfo", new Page<>(pageNum, 10));
        model.addAttribute("item", iPage.getRecords());
//        int studentid1 = iPage.getRecords().get(0).getStudentid();
        model.addAttribute("item2", iPage.getRecords().get(0).getStudentid());
        return "news";
    }
}
