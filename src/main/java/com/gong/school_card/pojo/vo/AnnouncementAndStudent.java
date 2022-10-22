package com.gong.school_card.pojo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pojo.vo.AnnouncementAndStudent
 * @Date: 2022年10月21日 09:26
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementAndStudent {

    private int studentid;//共有
    private String name;

    //字段填充内容
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    private String gz;
    private int deleted;
}
