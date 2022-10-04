package com.gong.school_card.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pojo.Admin
 * @Date: 2022年09月13日 20:05
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @TableId(value = "admin")
    private String Admin;
    private String Adminpass;
}
