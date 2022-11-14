package com.atguigu.springcloud.service.exception;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackServce implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "fall back...................";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "fall back...................";
    }
}
