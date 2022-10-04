package com.gong.school_card.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pojo.TestLogin
 * @Date: 2022年09月20日 16:49
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Testlogin {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String test;
}
