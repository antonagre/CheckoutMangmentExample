package com.example.demo.repository;

import com.example.demo.model.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepository extends MongoRepository<Product,ObjectId> {
    public Product findProductByName(String name);
}
