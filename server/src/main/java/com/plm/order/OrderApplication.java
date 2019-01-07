package com.plm.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/*
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
*/
@SpringCloudApplication
@EnableFeignClients(basePackages = "com.plm.product.client")
@MapperScan(basePackages = "com.plm.order.message.mapper")
@ComponentScan(basePackages = "com.plm")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
