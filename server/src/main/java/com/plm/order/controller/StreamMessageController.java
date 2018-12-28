package com.plm.order.controller;

import com.plm.order.dto.OrderDTO;
import com.plm.order.message.foundation.StreamClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;


/**
 * @author : cwh
 * 2018/12/27 0027
 * description ：
 */
@RestController
@Slf4j
public class StreamMessageController {

    @Resource
    private StreamClient streamClient;

    @GetMapping("/streamMessage")
    public void sendMessage(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }

    @GetMapping("/streamMessage2")
    public void sendMessage2(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("12345678");
        streamClient.input().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
