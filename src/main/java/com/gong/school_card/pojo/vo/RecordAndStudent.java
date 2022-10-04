package com.gong.school_card.pojo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pojo.vo.RecordAndStudent
 * @Date: 2022年09月15日 20:14
 * @Description:
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class RecordAndStudent {

    @TableId(value = "id", type = IdType.AUTO)
    @TableField("id")
    private Integer id;

    @TableField("studentid")
    private Integer studentid;

    @TableField("balance")
    private String balance;

    //字段填充内容
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    //学生姓名
    private String name;

}
