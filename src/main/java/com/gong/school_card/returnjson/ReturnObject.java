package com.gong.school_card.returnjson;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReturnObject {

    private Integer code = 200;
    private Integer total;
    private String message = "";
    private Object data;

    public ReturnObject(Integer code, String message, Integer total, Object result) {
        this.code = code;
        this.message = message;
        this.total = total;
        this.data = result;
    }

    public ReturnObject(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
