package tech.buildrun.orderms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.buildrun.orderms.entity.OrderEntity;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
}
