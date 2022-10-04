package com.gong.school_card.pojo;

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
 * @Pcakage: com.gong.school_card.pojo.Record
 * @Date: 2022年09月12日 07:55
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {

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

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
