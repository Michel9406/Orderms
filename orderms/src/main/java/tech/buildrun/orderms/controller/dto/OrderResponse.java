package tech.buildrun.orderms.controller.dto;

import tech.buildrun.orderms.entity.OrderEntity;

import java.math.BigDecimal;

public record OrderResponse(Long orderId,
                            Long customerId,
                            BigDecimal total) {

    public static OrderResponse fromEntity(OrderEntity entity) {
        return new OrderResponse(entity.getOrdersId(), entity.getCustomerId(), entity.getTotal());
    }
}