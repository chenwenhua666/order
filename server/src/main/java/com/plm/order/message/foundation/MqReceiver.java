package com.plm.order.message.foundation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author : cwh
 * 2018/12/26 0026
 * description ：
 */
@Slf4j
@Component
public class MqReceiver {
    @Resource
    private AmqpTemplate amqpTemplate;

    //1、@RabbitListener(queues = "myQueue")
    //2、@RabbitListener(queuesToDeclare = @Queue("myQueue"))
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void onMessage(String message){
        log.info("MqReceiverMessage: {}",message);
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")
    ))
    public void onComputerMessage(String message){
        log.info("computerMessage: {}",message);
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")
    ))
    public void onFruitMessage(String message){
        log.info("fruitMessage: {}",message);
    }


}
