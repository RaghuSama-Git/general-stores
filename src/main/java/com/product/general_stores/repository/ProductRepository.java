package com.product.general_stores.repository;

import com.product.general_stores.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> getAllProductsByCategory(String category);
}
