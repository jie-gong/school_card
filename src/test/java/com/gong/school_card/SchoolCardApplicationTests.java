package com.gong.school_card;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gong.school_card.mapper.CardMapper;
import com.gong.school_card.mapper.RecordMapper;
import com.gong.school_card.mapper.StudentMapper;
import com.gong.school_card.mapper.UserMapper;
import com.gong.school_card.pojo.Card;
import com.gong.school_card.pojo.Student;
import com.gong.school_card.pojo.redisStudent;
import com.gong.school_card.pojo.vo.RecordAndStudent;
import com.gong.school_card.pojo.vo.UserAndStudent;
import com.gong.school_card.services.impl.StudentServicesImpl;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
class SchoolCardApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Test
    public void SelectStudent1() {
        List<RecordAndStudent> records = recordMapper.selectLists();
        for (RecordAndStudent record : records) {
            System.out.println(record);
        }
    }

    @Test
    public void SelectBalance() {
        HashMap<String, Object> objectIntegerHashMap = new HashMap<>();
        objectIntegerHashMap.put("cardid", "2001");
        List<Card> cards = cardMapper.selectByMap(objectIntegerHashMap);
        System.out.println(cards);
    }

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void SelectStudent() {
        QueryWrapper<Student> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("studentid", "2020030602");
        Student student = studentMapper.selectOne(userQueryWrapper);
        System.out.println(student);
    }


    @Test
    public void a() {
        Card card = cardMapper.ShowOne(2001);
        System.out.println("账户余额为" + card);
        Integer balance = Integer.parseInt(card.getBalance());
        Integer balance2 = balance + 10;
        System.out.println(balance2);
        card.setBalance(balance2.toString());
        card.setStudentid(2001);
        cardMapper.updateById(card);
        System.out.println("充值成功");

    }

    @Test
    //双插入
    public void b() {
//        Student student = new Student();
//        student.setSex(1);
//        student.setName("源氏");
//        student.setMagor("c");
//        int insert = studentMapper.insert(student);
//        System.out.println("插入成功"+insert);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("name", "源氏");
        List<Student> students = studentMapper.selectByMap(stringObjectHashMap);
        students.forEach(System.out::println);
        Integer studentid = students.get(0).getStudentid();
        System.out.println(studentid);
        Card card = new Card();
        card.setStudentid(2005);
        card.setBalance("0");
        int insert1 = cardMapper.addStudent(card);
        System.out.println("插入成功" + insert1);
    }

    @Autowired
    UserMapper userMapper;

    @Test
    public void select() {
        List<UserAndStudent> userAndStudents = userMapper.selectUser();
        userAndStudents.forEach(System.out::println);
    }

    @Test
    public void selectByName() {
        String name = "公杰";
        List<UserAndStudent> userAndStudents = userMapper.selectUserByName("公杰");
        userAndStudents.forEach(System.out::println);
    }

    @Test
    //添加对象集合至redis
    //获取对象集合
    public void add() {
        List<Student> students = studentMapper.selectList(null);
        JSONObject.toJSON(students);
        students.forEach(System.out::println);
        System.out.println(students);
    }

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    //redis存入List集合
    public void ListB() {
        List<Student> list = studentMapper.selectList(null);
        list.forEach(System.out::println);
        redisTemplate.opsForList().rightPush("student", list);
        List range = stringRedisTemplate.opsForList().range("student", 0, -1);
        ObjectMapper mapper = new ObjectMapper();
        Object o = mapper.convertValue(range, new TypeReference<Object>() {
        });
        System.out.println(o);
    }

    @Test
    public void ListA() {
        ListOperations<String, Student> listOperations = redisTemplate.opsForList();
        List<Student> list1 = listOperations.range("student", 0, -1);
        String s = list1.toString();
        System.out.println(s);

    }

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void mm() {
        List<String> students1 = stringRedisTemplate.opsForList().range("student", 0, -1);
        for (String s : students1) {
            System.out.println(s);
        }
//        List<Student> list = new ArrayList<>();
//        list.add((Student) students1);
//        list.forEach(System.out::println);
    }

    @Test
    public void mms() {
        List<String> students1 = stringRedisTemplate.opsForList().range("student", 0, -1);
        List<Student> list = studentMapper.selectList(null);
        list.forEach(System.out::println);
        System.out.println("===============================================");
        for (String s : students1) {
            System.out.println(s);
        }
    }

    @Autowired
    StudentServicesImpl studentServices;

    @Test
    public void qwe() {
//        AAA();
        aaa();
    }

    void aaa() {
        ListOperations<String, Student> listOps = redisTemplate.opsForList();
        List<Student> list = studentMapper.selectList(null);
        listOps.leftPushAll("student", list);
    }

    void AAA() {
        List<String> students = stringRedisTemplate.opsForList().range("user", 0, -1);
        String jsonString = students.toString();
        List<Student> list2 = JSON.parseArray(jsonString, Student.class);
        for (Student student : list2) {
            System.out.println(student);
        }
        System.out.println("++++++++++++++===============+++++++++++");
        for (String student : students) {
            System.out.println(student);
        }
    }


    @Test
    //清除token缓存
    public void clearToken() {
        Boolean admin = redisTemplate.delete("admin");
        System.out.println(admin);
    }

    //获取缓存
    @Test
    public void getTokenForRedis() {
        Object admin = redisTemplate.opsForValue().get("admin");
        System.out.println(admin);
    }

    @Test
    public void clearRedis() {
        Set keys = redisTemplate.keys("*");
        keys.forEach(System.out::println);
        //迭代
        Iterator<String> iterator = keys.iterator();
        //通过while删除
        while (iterator.hasNext()) {
            redisTemplate.delete(iterator.next());
        }
//        if (ObjectUtils.isEmpty(keys)) {
//            redisTemplate.delete(keys);
//        }
    }
}
