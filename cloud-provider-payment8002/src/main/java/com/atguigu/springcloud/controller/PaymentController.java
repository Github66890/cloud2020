package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @author 86187
 */

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;

    /**
     * 写操作
     */
    @RequestMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int res = paymentService.create(payment);
        log.info("***插入结果了****");
        if (res>0){
            return  new CommonResult(200,"插入成功,serverPort："+serverPort,res);
        }else {
            return new CommonResult<>(444,"插入数据失败serverPort："+serverPort,null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment res = paymentService.getPaymentById(id);
        log.info("***插入结果****");
        if (res!=null){
            return  new CommonResult(200,"查询成功,serverPort："+serverPort,res);
        }else {
            return new CommonResult<>(444,"查询数据失败,serverPort："+serverPort,null);
        }
    }
}
