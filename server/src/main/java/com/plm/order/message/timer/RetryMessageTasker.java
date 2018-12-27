package com.plm.order.message.timer;

import com.plm.order.message.constant.Constants;
import com.plm.order.message.mapper.BrokerMessageLogMapper;
import com.plm.order.message.pojo.BrokerMessageLog;
import com.plm.order.message.producer.RabbitOrderSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author : cwh
 * 2018/12/27 0027
 * description ：
 */
@Component
public class RetryMessageTasker {
    @Resource
    private RabbitOrderSender rabbitOrderSender;

    @Resource
    private BrokerMessageLogMapper brokerMessageLogMapper;

    // @Scheduled(initialDelay = 5000, fixedDelay = 10000)
    public void reSend(){
        System.out.println("定时任务开始---");
        //pull status = 0 and timeout message
        List<BrokerMessageLog> list = brokerMessageLogMapper.query4StatusAndTimeoutMessage();
        for (BrokerMessageLog messageLog: list) {
            if(messageLog.getTryCount() >= 3){
                //update fail message
                brokerMessageLogMapper.changeBrokerMessageLogStatus(messageLog.getMessageId(), Constants.ORDER_SEND_FAILURE, new Date());
            } else {
                // resend
                brokerMessageLogMapper.update4ReSend(messageLog.getMessageId(), new Date());
                try {
                    rabbitOrderSender.sendMessage(messageLog.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
