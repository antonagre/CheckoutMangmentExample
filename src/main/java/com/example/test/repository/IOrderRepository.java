package com.example.test.repository;

import com.example.test.model.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IOrderRepository extends MongoRepository<Order,ObjectId> {
    public Order findDistinctByOrderId(String orderId);
    public boolean existsOrderByOrderId(String orderId);

}
