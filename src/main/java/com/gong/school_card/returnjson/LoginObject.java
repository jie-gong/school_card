package com.gong.school_card.returnjson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.returnjson.LoginObject
 * @Date: 2022年10月12日 15:44
 * @Description: 返回token
 */
@Data
@NoArgsConstructor
public class LoginObject {
    private Integer code = 200;
    private String message = "操作成功";
    private String token;

    public LoginObject(Integer code, String message, String token) {
        this.code = code;
        this.message = message;
        this.token = token;
    }
}
