package com.example.repository;

import com.example.springsoap.gen.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class SProductRepository {

    private static final Map<String, Product> products = new HashMap<>();

    @PostConstruct
    public void initData() {
       Product p = new Product();
       p.setId(11342234);
       p.setName("Aceite");
       p.setPrezzo(5);
       products.put("Aceite",p);
    }

    public Product findProduct(String name) {
        return products.get(name);
    }
}


