package com.gong.school_card.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pojo.Resul
 * @Date: 2022年09月21日 15:20
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resul {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String html;
    private String java;
    private String spring;
    private String mybatis;
    private String mysql;
    private String bootstrap;
}
