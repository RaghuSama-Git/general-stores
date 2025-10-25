package com.product.general_stores.service.implementations;

import com.product.general_stores.model.Product;
import com.product.general_stores.repository.ProductRepository;
import com.product.general_stores.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;

    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getAllProductsById(String category) {
       return productRepo.getAllProductsByCategory(category);
    }

    @Override
    public List<Product> insertProductsIntoDatabase(List<Product> productList) {
        return productRepo.saveAll(productList);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
