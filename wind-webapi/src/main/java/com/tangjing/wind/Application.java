package com.tangjing.wind;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Describe:
 * User:tangjing
 * Date:2017/7/31
 * Time:下午2:04
 */
@MapperScan("com.tangjing.wind.dao")
@SpringBootApplication
public class Application {




    public static void main(String[] args){
        SpringApplication.run(Application.class, args);

    }
}