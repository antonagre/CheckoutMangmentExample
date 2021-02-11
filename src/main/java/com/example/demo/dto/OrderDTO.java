package com.example.demo.dto;

import com.example.demo.model.Product;
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
