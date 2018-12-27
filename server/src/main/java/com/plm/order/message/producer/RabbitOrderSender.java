package com.plm.order.message.producer;

import com.alibaba.fastjson.JSONObject;
import com.plm.order.message.constant.Constants;
import com.plm.order.message.mapper.BrokerMessageLogMapper;
import com.plm.order.message.pojo.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author : cwh
 * 2018/12/26 0026
 * description ：
 */
@Component
public class RabbitOrderSender {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private BrokerMessageLogMapper brokerMessageLogMapper;

    //回调函数: confirm确认
    private RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.out.println("ack: " + ack);
            String messageId = correlationData.getId();
            if(ack){
                System.out.println("消息确认---confirm");
                //如果confirm返回成功 则进行更新
                brokerMessageLogMapper.changeBrokerMessageLogStatus(messageId, Constants.ORDER_SEND_SUCCESS, new Date());
            } else {
                //失败则进行具体的后续操作:重试 或者补偿等手段
                System.err.println("异常处理...");
            }
        }
    };
    //发送消息方法调用: 构建自定义对象消息
    public void sendMessage(String order) throws Exception {
        Order o = JSONObject.parseObject(order,Order.class);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        //消息唯一ID
        CorrelationData correlationData = new CorrelationData(o.getMessageId());
        rabbitTemplate.convertAndSend("order-exchange", "order.ABC", order, correlationData);
    }
}
