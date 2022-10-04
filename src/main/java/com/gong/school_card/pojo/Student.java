package com.gong.school_card.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pojo.Student
 * @Date: 2022年09月11日 14:30
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    //学生id
    @TableId(value = "studentid", type = IdType.AUTO)
    private Integer studentid;
    //学生姓名
    private String name;
    //学生专业
    private String magor;
    //学生性别
    private Integer sex;
    //学生电话
    private String phone;

    @TableLogic//逻辑删除注解
    private Integer deleted;
    @Version //乐观锁version
    private Integer version;
    //字段填充内容
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    private String idcard;

    //多表查询
//    private Card card;
//    private Record record;

}
