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
 * @Pcakage: com.gong.school_card.pojo.PagerStudent
 * @Date: 2022年09月20日 10:34
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("pagerstudent")
public class PagerStudent implements Serializable {
    //学生id
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    //学生姓名
    private String name;
    //学生专业
    private String magor;

    @TableLogic//逻辑删除注解
    private Integer deleted;

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
