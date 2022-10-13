package com.gong.school_card.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pojo.T_user
 * @Date: 2022年09月11日 09:38
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableId(value = "studentid", type = IdType.AUTO)
    private Integer studentid;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("kay")
    private String kay;
    @TableLogic//逻辑删除注解
    private Integer deleted;
    //字段填充内容
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
