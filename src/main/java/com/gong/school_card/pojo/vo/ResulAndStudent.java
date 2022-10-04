package com.gong.school_card.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pojo.vo.ResulAndStudent
 * @Date: 2022年09月21日 15:33
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResulAndStudent {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String java;
    private String html;
    private String spring;
    private String mybatis;
    private String mysql;
    private String bootstrap;

    private Integer Studentid;
}
