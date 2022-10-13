package com.gong.school_card.returnjson;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReturnObject {
    private Integer code = 200;
    private String message ;
//    private String token;

    public ReturnObject(Integer code, String message) {
        this.code = code;
        this.message = message;
//        this.token = token;
    }
}
