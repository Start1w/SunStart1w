package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
public class App {
    public static void main(String[] args) {
        // 参数1. 类名.class  参数: main方法的参数
        SpringApplication.run(App.class, args);
    }
}

