package com.plm.order.message.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author : cwh
 * 2018/12/26 0026
 * description ：
 */
@Data
public class BrokerMessageLog {
    private String messageId;

    private String message;

    private Integer tryCount;

    private String status;

    private Date nextRetry;

    private Date createTime;

    private Date updateTime;
}
