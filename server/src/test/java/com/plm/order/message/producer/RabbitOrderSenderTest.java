package com.plm.order.message.producer;

import com.alibaba.fastjson.JSON;
import com.plm.order.message.pojo.Order;
import com.plm.order.message.service.RabbitOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.UUID;

/**
 * @author : cwh
 * 2018/12/26 0026
 * description ：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitOrderSenderTest {

    @Resource
    private RabbitOrderSender rabbitOrderSender;

    @Resource
    private RabbitOrderService rabbitOrderService;

    @Test
    public void testSend() throws Exception{
        Order order = new Order();
        order.setId("20181226001");
        order.setName("测试1");
        order.setMessageId(System.currentTimeMillis()+"_"+UUID.randomUUID().toString());
        rabbitOrderSender.sendMessage(JSON.toJSONString(order));
    }

    @Test
    public void testOrderSend() throws Exception{
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setName("测试2");
        order.setMessageId(System.currentTimeMillis()+"_"+UUID.randomUUID().toString());
        rabbitOrderService.createOrder(order);
    }
}