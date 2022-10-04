package com.gong.school_card.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pojo.Announcement
 * @Date: 2022年09月19日 09:07
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String gz;
    @TableLogic//逻辑删除注解
    private Integer deleted;
    //字段填充内容
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
