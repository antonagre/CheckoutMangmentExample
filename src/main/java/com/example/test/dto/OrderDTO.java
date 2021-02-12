package com.example.test.dto;

import com.example.test.model.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder

public class OrderDTO {
    String id;
    int total;
    List<Product> cart;
}
