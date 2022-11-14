package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author 86187
 */

@EnableDiscoveryClient
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;
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
            return  new CommonResult(200,"插入成功,serverPort:"+serverPort,res);
        }else {
            return new CommonResult<>(444,"插入数据失败,serverPort："+serverPort,null);
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

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String ele:services) {
            log.info("*****element"+ele);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance ins:instances) {
            log.info(ins.getServiceId()+"\t"+ins.getHost()+"\t"+ins.getPort()+"\t"+ins.getUri());
        }
        return this.discoveryClient;
    }
}
