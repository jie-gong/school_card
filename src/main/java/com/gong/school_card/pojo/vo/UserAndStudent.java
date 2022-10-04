package com.gong.school_card.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pojo.vo.UserAndStudent
 * @Date: 2022年09月20日 17:34
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAndStudent {
    @TableId(value = "studentid", type = IdType.AUTO)
    private Integer studentid;
    private String username;
    private String password;
    private String kay;


    //学生姓名
    private String name;
}
