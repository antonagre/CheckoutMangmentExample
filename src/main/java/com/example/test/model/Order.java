package com.example.test.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "orders")
public class Order {
    @Id
    String _id;
    String orderId;
    List<Product> cart;
    int total;

}
