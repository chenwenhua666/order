package com.plm.order.controller;

import com.plm.order.config.AuthorConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : cwh
 * 2018/12/25 0025
 * description ：
 */
@RestController
public class AuthorContorller {
    @Resource
    private AuthorConfig authorConfig;

    @GetMapping(value = "/auth/print")
    public String printAuth(){
        return "name"+authorConfig.getName()+"--"+"age"+authorConfig.getAge();
    }
}
