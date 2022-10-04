package com.gong.school_card.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gong.school_card.pojo.Student;
import com.gong.school_card.pojo.vo.CardAndStudent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.mapper.StudentMapper
 * @Date: 2022年09月11日 14:34
 * @Description:
 */
@Mapper
@Repository//持久层框架
public interface StudentMapper extends BaseMapper<Student> {
    //删除学生  查询删除记录
    List<Student> selectDelete(int deleted);
    //撤销删除  跟新数据库表内的deleted
    int  updateStudents(Student student);

    //查询学生姓名

    List<Student> getname(String name);

    //多表查询 查询学生余额与信息
//    List<CardAndStudent>selectListBalances();

}
