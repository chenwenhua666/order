package com.plm.order.message.foundation;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author : cwh
 * 2018/12/27 0027
 * description ：
 */
public interface StreamClient {

    String INPUTMSG = "myStreamInputMessage";
    String OUTPUTMSG = "myStreamOutputMessage";
    String OUTPUTMSG2 = "myStreamOutputMessage2";

    @Input(INPUTMSG)
    SubscribableChannel input();

    @Output(OUTPUTMSG)
    MessageChannel output();

    @Output(OUTPUTMSG2)
    MessageChannel output2();

}
