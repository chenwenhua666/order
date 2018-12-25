package com.plm.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * chenwenhua
 * 2018\11\11 0011
 * 18:20
 */
@RestController
@Slf4j
public class ClientController {

   @Resource
    private LoadBalancerClient loadBalancerClient;

   /*@Resource
   private RestTemplate restTemplate;
*/
    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        /*//1
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://127.0.0.1:8080/msg",String.class);
        log.info("result={}",result);
        return result;*/

       //2
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()+"/msg");
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);
        log.info("result={}",result);
        return result;

        /*//3
        String result = restTemplate.getForObject("http://PRODUCT/msg",String.class);
        log.info("result={}",result);
        return result;
*/
    }



}
