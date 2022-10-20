package com.gong.school_card.pccontroller;

import com.gong.school_card.mapper.CardMapper;
import com.gong.school_card.mapper.RecordMapper;
import com.gong.school_card.pojo.vo.CardAndStudent;
import com.gong.school_card.pojo.vo.RecordAndStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;



/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pccontroller.CardController
 * @Date: 2022年09月13日 10:01
 * @Description:
 */


@Controller
public class CardController {
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private CardMapper cardMapper;

    //时间升序
    @GetMapping("/time/ascending")
    public String TimeAscending(Model model) {
        List<RecordAndStudent> recordAndStudents = recordMapper.TimeAscending();
        model.addAttribute("list", recordAndStudents);
        return "recharge_record";
    }

    //姓名升序
    @GetMapping("/name/ascending")
    public String NameAscending(Model model) {
        List<RecordAndStudent> recordAndStudents = recordMapper.NameAscending();
        model.addAttribute("list", recordAndStudents);
        return "recharge_record";
    }

    //通过姓名查询充值记录
    @PostMapping("/select/record")
    public String selectRecord(String name, Model model) {
        List<RecordAndStudent> recordAndStudents = recordMapper.selectByName(name);
        model.addAttribute("list", recordAndStudents);
        return "recharge_record";
    }

    /**
     * 查询学生充值记录
     */
    @GetMapping("/recharge/record")
    public String recharge(Model model) {
        List<RecordAndStudent> recordAndStudents = recordMapper.selectLists();
        model.addAttribute("list", recordAndStudents);
        return "recharge_record";
    }

    //显示学生单独的充值记录
    @GetMapping("/showbalance/{studentid}")
    public String ShowBalance(@PathVariable("studentid") int id, Model model) {
        List<CardAndStudent> cardAndStudents = cardMapper.selectBalance(id);
        model.addAttribute("pageInfo", cardAndStudents);
        return "Showbalance";
    }

}
