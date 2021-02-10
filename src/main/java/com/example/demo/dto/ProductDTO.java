package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder

public class ProductDTO {
    @Id
    String id;
    String name;
    int prezzo;
}