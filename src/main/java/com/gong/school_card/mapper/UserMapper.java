package com.gong.school_card.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gong.school_card.pojo.Student;
import com.gong.school_card.pojo.User;
import com.gong.school_card.pojo.vo.UserAndStudent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.mapper.T_userMapper
 * @Date: 2022年09月11日 09:44
 * @Description:
 */
@Mapper//这个注解表示了 这是一个mybatis的mapper类
@Repository
public interface UserMapper extends BaseMapper<User> {

    //恢复删除的记录    更新数据 使deleted返回为o
    int user(User user);

    //通过学生的id查询
    List<Student>getStudent();

    //查询学生姓名与账号密码
    List<UserAndStudent>selectUser();

    //通过姓名来查找
    List<UserAndStudent>selectUserByName(String name);


}
