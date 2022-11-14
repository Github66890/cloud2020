package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther zzyy
 * @create 2020-01-30 17:32
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderZK80
{
    public static void main(String[] args)
    {
        SpringApplication.run(OrderZK80.class,args);
    }
}
 
 

