package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder

public class checkoutDTO {
    String id;
    int total;
}
