package com.gong.school_card.phonecontroller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gong.school_card.mapper.CardMapper;
import com.gong.school_card.mapper.RecordMapper;
import com.gong.school_card.mapper.StudentMapper;
import com.gong.school_card.mapper.UserMapper;
import com.gong.school_card.pojo.Card;
import com.gong.school_card.pojo.Record;
import com.gong.school_card.pojo.Student;
import com.gong.school_card.pojo.User;
import com.gong.school_card.returnjson.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.phonecontroller.Controller
 * @Date: 2022年09月11日 09:44
 * @Description:
 */

@RequestMapping("/card")
@Controller
public class PhoneController {
    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RecordMapper recordMapper;

    @PostMapping("/balance")//查询余额
    @ResponseBody
    public Object getY(@RequestBody JSONObject jsonObject) {
        String studentid = jsonObject.getString("studentid");
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("studentid", studentid);
        List<Card> cards = cardMapper.selectByMap(stringObjectHashMap);
        cards.forEach(System.out::println);
        if (cards == null) {
            return JSONObject.toJSON(new ReturnObject(400, "查询失败"));
        } else {
            return JSONObject.toJSON(cards);
        }
    }


    @PostMapping("/student")//查询学生信息
    @ResponseBody
    public Object getS(@RequestBody JSONObject jsonObject) {
        String studentid = jsonObject.getString("studentid");
        QueryWrapper<Student> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("studentid", studentid);
        Student student = studentMapper.selectOne(userQueryWrapper);
        System.out.println(student);
        if (student == null) {
            return JSONObject.toJSON(new ReturnObject(400, "查询失败"));
        } else {
            return JSONObject.toJSON(student);
        }
    }

    @GetMapping("/addStudent")//用户注册
    @ResponseBody
    public Object addStudents(@RequestBody JSONObject jsonObject) {
        if (jsonObject != null) {
            String name = jsonObject.getString("name");
            String magor = jsonObject.getString("magor");
            int sex = jsonObject.getInteger("sex");
            String phone = jsonObject.getString("phone");
            String idcard = jsonObject.getString("idcard");
            Card card = new Card();
            Student student = new Student();
            student.setIdcard(idcard);
            student.setPhone(phone);
            student.setMagor(magor);
            student.setName(name);
            student.setSex(sex);
            studentMapper.insert(student);
            HashMap<String, Object> objectStringHashMap = new HashMap<>();
            objectStringHashMap.put("idcard", idcard);
            List<Student> students = studentMapper.selectByMap(objectStringHashMap);
            Integer studentid1 = students.get(0).getStudentid();
            System.out.println(studentid1);
            card.setStudentid(studentid1);
            card.setBalance("0");
            cardMapper.insert(card);
            return JSONObject.toJSON(new ReturnObject(200, "添加成功"));
        } else {
            return JSONObject.toJSON(new ReturnObject(400, "添加失败"));
        }
    }

    @GetMapping("/adduser")//用户注册
    @ResponseBody
    public Object register(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        Integer studentid = jsonObject.getInteger("studentid");
        String kay = jsonObject.getString("kay");
        User user = new User();
        user.setKay(kay);
        user.setUsername(username);
        user.setPassword(password);
        user.setStudentid(studentid);
        int insert = userMapper.insert(user);
        if (insert != 0) {
            return JSONObject.toJSON(new ReturnObject(200, "注册成功"));
        } else {
            return JSONObject.toJSON(new ReturnObject(400, "注册失败"));
        }
    }

    @GetMapping("/saveMoney")//充值余额  添加充值记录
    @ResponseBody
    public Object getYuE(@RequestBody JSONObject jsonObject) {
        int studentid = jsonObject.getInteger("studentid");
        String balance = jsonObject.getString("balance");
        //查询数据
        if (balance.equals("0")) {
            return JSONObject.toJSON(new ReturnObject(500, "充值金额不能为空"));
        }
        Card card = cardMapper.ShowOne(studentid);
        /**
         * 获取两次数据  整合充值金额 进行相加
         */
        int i = Integer.parseInt(card.getBalance());//强转获取的余额类型
        Integer i1 = Integer.parseInt(balance);
        Integer getY = (i + i1);//整合接口数据
        //充值数据库内容
        card.setStudentid(studentid);
        card.setBalance(getY.toString());
        cardMapper.updateById(card);
        //添加充值记录
        Record record = new Record();
        record.setBalance(balance);
        record.setStudentid(studentid);
        if (balance.equals("0")) {
            return JSONObject.toJSON(new ReturnObject(500, "充值金额不能为空"));
        } else {
            recordMapper.insert(record);
        }
        return JSONObject.toJSON(new ReturnObject(200, "添加成功"));
    }

    //修改学生信息
    @GetMapping("/update")
    @ResponseBody
    public Object update(@RequestBody JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String phone = jsonObject.getString("phone");
        Integer sex = jsonObject.getInteger("sex");
        Student student = new Student();
        student.setPhone(phone);
        student.setSex(sex);
        student.setName(name);
        studentMapper.updateById(student);
        return null;
    }
}
