package com.gong.school_card.services.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gong.school_card.mapper.StudentMapper;
import com.gong.school_card.pojo.Student;
import com.gong.school_card.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.services.impl.StudentServicesImpl
 * @Date: 2022年09月26日 11:29
 * @Description:
 */
@Service
public class StudentServicesImpl extends ServiceImpl<StudentMapper, Student> implements StudentServices {
    @Autowired
    private StudentMapper studentMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, Student> redisTemplate;

    @Override
    public List<Student> selectDelete(int deleted) {
        //使用ListOperations对象操作redis list
        ListOperations<String, Student> listOps = redisTemplate.opsForList();
        List<Student> students = redisTemplate.opsForList().range("delete", 0, -1);

        List<Student> o = (List<Student>) JSONObject.toJSON(students);
        String jsonString = o.toString();
        List<Student> list = JSON.parseArray(jsonString, Student.class);
        //线程锁
        if (list.size() == 0) {
            synchronized (this.getClass()) {
                list = JSON.parseArray(jsonString, Student.class);
                if (list.size() == 0) {
                    //查询数据库
                    System.out.println("查询数据库1111");
                    List<Student> list2 = studentMapper.selectDelete(deleted);
                    //判断缓存内有无数据
                    if (list2.size() == 0) {
                        return list2;
                    }
                    listOps.leftPushAll("delete", list2);
                    List<Student> students02 = redisTemplate.opsForList().range("delete", 0, -1);
//                    List<Student> o = (List<Student>) JSONObject.toJSON(students);
                    List<Student> o1 = (List<Student>) JSONObject.toJSON(students02);
                    String aa = o1.toString();
                    List<Student> list02 = JSON.parseArray(aa, Student.class);
                    return list02;
                } else {
                    System.out.println("查询(同步代码快)缓存");
                    return list;
                }
                //如果list2内没有数据，则重新查询数据库
            }
        } else {
            System.out.println("查询缓存");
        }
        return list;
    }

    /**
     * 配置线程锁 防止多次查询数据库
     *
     * @return
     */
    @Override
    public List<Student> listStudentL() {
        //使用ListOperations对象操作redis list
        ListOperations<String, Student> listOps = redisTemplate.opsForList();
        List<Student> students = redisTemplate.opsForList().range("student", 0, -1);
        List<Student> o = (List<Student>) JSONObject.toJSON(students);
        String jsonString = o.toString();
        List<Student> list = JSON.parseArray(jsonString, Student.class);
        //线程锁
        if (list.size() == 0) {
            synchronized (this.getClass()) {
                list = JSON.parseArray(jsonString, Student.class);
                if (list.size() == 0) {
                    //查询数据库
                    System.out.println("查询数据库1111");
                    List<Student> list2 = studentMapper.selectList(null);
                    listOps.leftPushAll("student", list2);
                    List<Student> students02 = redisTemplate.opsForList().range("student", 0, -1);
//                    List<Student> o = (List<Student>) JSONObject.toJSON(students);
                    List<Student> o1 = (List<Student>) JSONObject.toJSON(students02);
                    String aa = o1.toString();
                    List<Student> list02 = JSON.parseArray(aa, Student.class);
                    return list02;
                } else {
                    System.out.println("查询(同步代码快)缓存");
                    return list;
                }
                //如果list2内没有数据，则重新查询数据库
            }
        } else {
            System.out.println("查询缓存");
        }
        return list;
    }

}
