package com.example.repository;

import com.example.model.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepository extends MongoRepository<Product,ObjectId> {
    public Product findDistinctByNameLike(String name);
    public boolean existsProductByNameLike(String name);
}
