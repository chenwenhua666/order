package com.plm.order.repository;

import com.plm.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * chenwenhua
 * 2018\10\14 0014
 * 12:43
 */

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    public List<OrderDetail> findByOrderId(String orderId);

}
