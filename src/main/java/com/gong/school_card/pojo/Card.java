package com.gong.school_card.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pojo.Card
 * @Date: 2022年09月11日 09:38
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @TableId(value = "studentid",type = IdType.AUTO)
    private Integer studentid;
    //余额 默认为零
    private String balance;
    @TableLogic//逻辑删除注解
    private Integer deleted;

}
