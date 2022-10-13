package com.gong.school_card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2//开启swaffer2
@SpringBootApplication
public class SchoolCardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolCardApplication.class, args);
    }

}
