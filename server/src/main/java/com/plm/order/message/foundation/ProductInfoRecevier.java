package com.plm.order.message.foundation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.plm.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : cwh
 * 2018/12/28 0028
 * description ：
 */
@Component
@Slf4j
public class ProductInfoRecevier {

    public static final String PRODUCT_STOCK_TEMPLATE = "productStock_%s";

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(bindings = @QueueBinding(
        exchange = @Exchange("productInfo-exchange"),
        key = "productInfo.decreaseStock",
        value = @Queue("productInfoQueue")
    ))
    public void receiveMessage(String message){
        List<ProductInfoOutput> productInfoOutputList = JSON.parseArray(message,ProductInfoOutput.class);
        log.info("收到消息：{}",productInfoOutputList);
        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            stringRedisTemplate.opsForValue().set(
                String.format(PRODUCT_STOCK_TEMPLATE,productInfoOutput.getProductId()),
                String.valueOf(productInfoOutput.getProductStock()));
        }
    }
}
