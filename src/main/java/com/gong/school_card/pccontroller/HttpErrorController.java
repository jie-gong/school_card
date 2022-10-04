package com.gong.school_card.pccontroller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.pccontroller.ErrorController
 * @Date: 2022年09月14日 10:18
 * @Description:
 */
//界面访问失败   ——————   404
@Controller
public class HttpErrorController implements ErrorController {
    private final static String ERROR_PATH = "/error";

    @GetMapping(value = ERROR_PATH)
    public String errorJson() {
        return "404";
    }
}
