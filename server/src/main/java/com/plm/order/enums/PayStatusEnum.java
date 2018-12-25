package com.plm.order.enums;

import lombok.Getter;

/**
 * chenwenhua
 * 2018\11\11
 */
@Getter
public enum PayStatusEnum{
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
