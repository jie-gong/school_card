package com.gong.school_card.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pojo.redisStudent
 * @Date: 2022年09月29日 10:03
 * @Description:
 */
@NoArgsConstructor
@Data
@AllArgsConstructor

public class redisStudent {

    @JsonProperty("studentid")
    private Integer studentid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("magor")
    private String magor;
    @JsonProperty("sex")
    private Integer sex;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("deleted")
    private Integer deleted;
    @JsonProperty("version")
    private Integer version;
    @JsonProperty("createTime")
    private String createTime;
    @JsonProperty("updateTime")
    private Long updateTime;
    @JsonProperty("idcard")
    private String idcard;
}
