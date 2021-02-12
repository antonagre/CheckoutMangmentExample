package com.example.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection ="products")
@Data
public class Product {
    @Id
    String id;
    String name;
    int prezzo;
}
