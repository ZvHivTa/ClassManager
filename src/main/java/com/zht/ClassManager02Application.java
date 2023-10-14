package com.zht;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication()
@EnableScheduling
@MapperScan(basePackages={"com.zht.mapper"})
public class ClassManager02Application {

    public static void main(String[] args) {
        SpringApplication.run(ClassManager02Application.class, args);
    }

}
