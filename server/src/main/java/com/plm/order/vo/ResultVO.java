package com.plm.order.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * chenwenhua
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
