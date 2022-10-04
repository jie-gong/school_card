package com.gong.school_card.services;

import com.gong.school_card.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xjjabc
 * @Project: JavaLaity
 * @Date: 2022年09月26日 11:29
 * @Description:
 */
@Service
public interface StudentServices {
    List<Student> selectDelete(int deleted);

    //使用redis存取数据
    List<Student> listStudentL();

}
