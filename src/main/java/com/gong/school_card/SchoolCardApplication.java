package com.gong.school_card;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.gong.school_card.mapper")
@SpringBootApplication
public class SchoolCardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolCardApplication.class, args);
    }

}
