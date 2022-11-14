package com.atguigu.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@Slf4j
@EnableFeignClients
@SpringBootApplication
public class OrderMainFegin80 {
    public static void main(String[] args) {
        log.info("80hello");
        log.info("hello");
        SpringApplication.run(OrderMainFegin80.class);
    }

}
