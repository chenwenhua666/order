package com.plm.order.message.foundation;

import com.plm.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author : cwh
 * 2018/12/27 0027
 * description ：
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    /*@StreamListener(value = StreamClient.INPUTMSG)
    public void onInputMessage(OrderDTO message){
        log.info("inputStreamReceiver:{}",message);
    }

    @StreamListener(value = StreamClient.OUTPUTMSG)
    public void onOutputMessage(OrderDTO message){
        log.info("outputStreamReceiver:{}",message);
    }*/

    @StreamListener(value = StreamClient.OUTPUTMSG)
    @SendTo(StreamClient.OUTPUTMSG2)
    public String onOutputMessage2(OrderDTO message){
        log.info("outputStreamReceiver:{}",message);
        return "接收消息";
    }

    @StreamListener(value = StreamClient.OUTPUTMSG2)
    public void onOutputMessage2(String message){
        log.info("回执消息:{}",message);
    }

}
