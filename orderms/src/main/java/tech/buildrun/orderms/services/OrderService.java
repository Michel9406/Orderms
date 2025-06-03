package tech.buildrun.orderms.services;


import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import tech.buildrun.orderms.controller.dto.OrderResponse;
import tech.buildrun.orderms.entity.OrderEntity;
import tech.buildrun.orderms.entity.OrderItem;
import tech.buildrun.orderms.listener.dto.OrderCreatedEvent;
import tech.buildrun.orderms.repository.OrderRepository;

import java.math.BigDecimal;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(OrderCreatedEvent event) {

        var entity = new OrderEntity();
        entity.setOrdersId(event.codigoPedido());
        entity.setCustomerId(event.codigoCliente());
        entity.setItems(getOrderItems(event));
        entity.setTotal(getTotal(event));


        orderRepository.save(entity);

    }

    public Page<OrderResponse> findAllByCustomerId (Long custumerId, PageRequest pageRequest) {
        var orders = orderRepository.findAllByCustomerId(custumerId, pageRequest);

        return  orders.map(OrderResponse::fromEntity);
    }



    private BigDecimal getTotal(OrderCreatedEvent event) {
        return event.itens()
                .stream()
                .map(i -> i.preco() .multiply(BigDecimal.valueOf(i.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private static List<OrderItem> getOrderItems(OrderCreatedEvent event) {
        return event.itens().stream()
                .map(i -> new OrderItem(i.produto(), i.quantidade(), i.preco()))
                .toList();
    }

}