package com.simba.goodfitmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.simba.goodfitmanager.dao")
public class GoodfitmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodfitmanagerApplication.class, args);
    }

}
