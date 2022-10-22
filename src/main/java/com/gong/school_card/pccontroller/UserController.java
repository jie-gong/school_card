package com.gong.school_card.pccontroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gong.school_card.mapper.*;
import com.gong.school_card.pojo.*;
import com.gong.school_card.pojo.vo.ResulAndStudent;
import com.gong.school_card.services.impl.StudentServicesImpl;
import com.gong.school_card.util.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pccontroller.UserController
 * @Date: 2022年09月14日 16:36
 * @Description:
 */
@Controller
public class UserController {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CardMapper cardMapper;


    //    @RequestMapping("/userlist")
//    public String show(Model model) {
//        List<Student> students = studentMapper.selectList(null);
//        model.addAttribute("list", students);
//        return "userlist";
//    }
    @Autowired
    private ControllerUtil controllerUtil;

    @GetMapping("/userlist")
    public String AllS(Model model, @RequestParam(defaultValue = "1", value = "pageNum") long pageNum, HttpServletRequest request) {
        Boolean aBoolean = controllerUtil.LoginUtil(request);
        if (aBoolean == false) {
            model.addAttribute("msg", "账号异地登陆，请确认账号密码安全");
            return "index";
        } else {
            Page<Student> page = new Page(pageNum, 10);
            studentMapper.selectPage(page, null);
            model.addAttribute("pageInfo", page);
            return "userlist";
        }
    }

    //跳转修改学生数据
    @GetMapping("/updatee/{studentid}")
    public String curUpdate(@PathVariable("studentid") int studentid, Model model) {
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.eq("studentid", studentid);
        Student student = studentMapper.selectOne(studentQueryWrapper);
        System.out.println(student);
        model.addAttribute("item", student);
        return "/emp/update";
    }

    //提交修改完毕的数据
    @PostMapping("/update")
    public String updateStudent(Student student) {
        studentMapper.updateById(student);
        return "redirect:/userlist";
    }

    //删除一个学生
    @GetMapping("/deleteStudent/{studentid}")
    public String deleteStudent(@PathVariable("studentid") int studentid) {
        studentMapper.deleteById(studentid);
        //重定向
        return "redirect:/userlist";
    }


    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Resource
    private RedisTemplate<String, Student> redisTemplate;

    @Resource
    private StudentServicesImpl studentServices;

    //回收站
    @RequestMapping("/RecycleBin")
    public String RecycleBin(Model model) {
        /**
         * 模拟数据拉扯
         */
//        ListOperations<String, Student> listOps = redisTemplate.opsForList();
//        List<Student> list2 = studentMapper.selectList(null);
//        listOps.leftPushAll("student", list2);
//        List<String> students = stringRedisTemplate.opsForList().range("student", 0, -1);
//        String jsonString = students.toString();
//        List<Student> list = JSON.parseArray(jsonString, Student.class);
//        list.forEach(System.out::println);

//        ListOperations<String, Student> listOps = redisTemplate.opsForList();
//        List<Student> students = redisTemplate.opsForList().range("student", 0, -1);
//        List<Student> o = (List<Student>) JSONObject.toJSON(students);
//        System.out.println(o);
//        System.out.println("+++++++===================++++++++++++++");
//        String s=o.toString();
//        List<Student> list = JSON.parseArray(s, Student.class);
//        list.forEach(System.out::println);
        /**
         * 回收站
         */
        List<Student> list = studentServices.selectDelete(1);
        if (list.size() == 0) {
            model.addAttribute("msg", "当前没有删除记录");
            return "studentlist";
        }
        /**
         * 测试数据
         */
//        List<Student> list = studentServices.listStudentL();

        model.addAttribute("select", list);
        return "studentlist";
    }

//    //回收站

//    @RequestMapping(value = "/RecycleBin")
//    public String RecycleBin(Model model) {
//        List<Student> students = studentMapper.selectDelete(1);
//        model.addAttribute("select", students);
//        return "studentlist";
//    }

    //撤销删除
    @GetMapping("/recession/{studentid}")
    public String Recession(@PathVariable("studentid") int studentid) {
        int deleted = 0;
        Student student = new Student();
        student.setStudentid(studentid);
        student.setDeleted(deleted);
        studentMapper.updateStudents(student);
        return "redirect:/RecycleBin";
    }

    @Autowired
    private RecordMapper recordMapper;


    //注册学生
    @PostMapping("/addStudent")
    public String AddStudent(Student student, Card card) {
        int insert = studentMapper.insert(student);
        /**
         * insert=1
         * 执行插入卡号的方法
         */
        if (insert == 0) {
            return "null";
        } else {
            card.setBalance("0");
            cardMapper.insert(card);
            return "redirect:/userlist";
        }
    }

    //查找学生
    @RequestMapping("/selecet/student")
    public String selectStudent(String selectUser, Model model) {
        System.out.println(selectUser);
        HashMap<String, Object> objectStringWeakHashMap = new HashMap<>();
        objectStringWeakHashMap.put("name", selectUser);
        List<Student> students = studentMapper.selectByMap(objectStringWeakHashMap);
        students.forEach(System.out::println);
        model.addAttribute("select", students);
        return "selectStudents";
    }

    @Autowired
    private AnnouncementMapper announcementMapper;

    @PostMapping("/getTip")
    public String getTip(Announcement announcement, Model model) {
        int insert = announcementMapper.insert(announcement);
//        if (insert == 1) {
        model.addAttribute("msg", "发布成功");
        System.out.println("插入成功" + insert);
        return "redirect:/select/GG";
//        }
//        return "";
    }

    //显示公告记录
    @RequestMapping("/select/GG")
    public String selectGG(Model model,
                           @RequestParam(defaultValue = "1", value = "pageNum") long pageNum) {
        Page<Announcement> page = new Page(pageNum, 10);
        announcementMapper.selectPage(page, null);
        model.addAttribute("pageInfo", page);
        return "/GG/histor";
    }

    //删除公告
    @GetMapping("/deleteGG/{id}")
    public String deleteGG(@PathVariable("id") int id) {
        announcementMapper.deleteById(id);
        return "redirect:/select/GG";
    }

    @Autowired
    private ResulMapper resulMapper;

    //添加学生成绩信息
    @GetMapping("/grade")
    public String Grade(Model model) {
        List<ResulAndStudent> resulAndStudents = resulMapper.selectResultInput();
        model.addAttribute("pageInfo", resulAndStudents);
        return "ResultInput";
    }

    //跳转学生成绩修改界面 并获取数据
    @GetMapping("/getUpdate/{id}")
    public String getUpdate(Model model, @PathVariable("id") int id) {
        Resul resul = resulMapper.selectById(id);
        System.out.println(resul);
        model.addAttribute("item", resul);
        return "ResultUpdate";
    }

    //跳转添加学生界面
    @GetMapping("/user/getGrade")
    public String userGetGrade() {
        return "ResultInster";
    }

    //提交学生成绩修改的数据
    @PostMapping("/Result/Update")
    public String ResultUpdate(Resul resul) {
        System.out.println(resul);
        resulMapper.updateById(resul);
        return "redirect:/grade";
    }

    //提交学生成绩信息
    @PostMapping("/Result/Inster")
    public String ResultInster(Resul resul, Model model) {
        String name1 = resul.getName();
        List<Student> getname = studentMapper.getname(name1);
        if (getname.size() == 0) {
            model.addAttribute("msg", "数据库查无此用户,请添加数据后重试");

            return "ResultInster";
        } else {
            resulMapper.insert(resul);
            return "redirect:/grade";
        }
    }

    //查找学生信息
    @RequestMapping("/selecet/grade")
    public String selecetgrade(String name, Model model) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", name);
        List<Resul> resuls = resulMapper.selectByMap(map);
        model.addAttribute("pageInfo", resuls);
        return "ResultInput";
    }
}
