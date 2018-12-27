package com.plm.order.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author : cwh
 * 2018/12/26 0026
 * description ：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MqReceiverTest {
    @Resource
    private AmqpTemplate amqpTemplate;

    @Test
    public void sendMessage() {
        amqpTemplate.convertAndSend("myQueue","now: "+ new Date());
    }

    @Test
    public void sendComputerMessage() {
        amqpTemplate.convertAndSend("myOrder","computer","computer-now: "+ new Date());
    }

    @Test
    public void sendFruitMessage() {
        amqpTemplate.convertAndSend("myOrder","fruit","fruit-now: "+ new Date());
    }
}