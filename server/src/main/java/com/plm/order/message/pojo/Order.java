package com.plm.order.message.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : cwh
 * 2018/12/26 0026
 * description ：
 */
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = -314314682650282053L;

    private String id;
    private String name;
    private String messageId;

    public Order() {
    }

    public Order(String id, String name, String messageId) {
        this.id = id;
        this.name = name;
        this.messageId = messageId;
    }
}
