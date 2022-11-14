package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author 86187
 */
@Slf4j
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MySelfRule.class)
@EnableEurekaClient
@SpringBootApplication
public class OrderMainApp80 {

    public static void main(String[] args) {
        log.info("hello");
        SpringApplication.run(OrderMainApp80.class);
    }
}
