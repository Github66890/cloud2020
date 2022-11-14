package com.atguigu.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @auther zzyy
 * @create 2019-11-12 14:31
 */
@Slf4j
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001
{
    public static void main(String[] args)
    {    log.info("901 hello");
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
}

 
 
 
 

