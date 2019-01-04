package com.plm.order.service;

import com.plm.order.dto.OrderDTO;

/**
 * chenwenhua
 * 2018\11\11 0011
 * 13:36
 */
public interface OrderService {
    OrderDTO create(OrderDTO orderDTO);

    OrderDTO finish(String orderId);
}
