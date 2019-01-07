package com.plm.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author : cwh
 * 2019/1/4 0004
 * description ：
 */
@RestController
@DefaultProperties(defaultFallback = "defaultCallBack")
public class HystrixController {
    /*
    //超时配置
    @HystrixCommand(commandProperties = {
        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "6000")
    })
    */
    /*
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),
    })*/
    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam Integer number){
        if (number > 1) {
            return "success";
        }
        RestTemplate restTemplate  = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8083/product/ListForOrder",
                Arrays.asList("164103465734242707"),String.class);
        //throw new RuntimeException("发生异常");
    }

    private String callBack(){
        return "请稍后再试";
    }

    private String defaultCallBack(){
        return "默认提示：请稍后再试";
    }

}
