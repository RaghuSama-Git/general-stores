package com.product.general_stores.service.interfaces;

import com.product.general_stores.model.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {
    List<Product> getAllProductsById(String category);

    List<Product> insertProductsIntoDatabase(List<Product> productList);

    List<Product> getAllProducts();
}
