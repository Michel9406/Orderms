package tech.buildrun.orderms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.PageRequest;
import tech.buildrun.orderms.controller.dto.OrderResponse;
import tech.buildrun.orderms.entity.OrderEntity;


public interface OrderRepository extends MongoRepository<OrderEntity, Long> {


    Page<OrderEntity> findAllByCustomerId(Long custumerId, PageRequest pageRequest);
}
