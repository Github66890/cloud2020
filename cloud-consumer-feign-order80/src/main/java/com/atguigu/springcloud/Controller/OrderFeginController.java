package com.atguigu.springcloud.Controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderFeginController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/comsumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentId(@PathVariable("id") Long id){
        log.info("hello");
        return paymentFeignService.getPaymentById(id);
    }
}
