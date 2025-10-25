package com.product.general_stores.controller;

import com.product.general_stores.model.Product;
import com.product.general_stores.service.interfaces.ProductService;
import com.product.general_stores.util.ResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public String getProduct() {
        return "Product details";
    }

    @GetMapping("/category/{category}")
    public ResponseDTO<List<Product>> getAllProductsOnCategory(@PathVariable String category) {
        ResponseDTO<List<Product>> responseDTO;

        if (category == null || category.isEmpty()) {
            return new ResponseDTO<>("FAIL", null, "Please provide the category");
        } else {
            List<Product> productList = productService.getAllProductsById(category);
            return new ResponseDTO<>("Success", productList, "List of products based on category");
        }
    }

    @GetMapping("/category")
    public ResponseDTO<List<Product>> getAllProductsList() {
        ResponseDTO<List<Product>> responseDTO;

        List<Product> productList = productService.getAllProducts();
        return new ResponseDTO<>("Success", productList, "List of all products");
    }

    @PostMapping("/order-item")
    public ResponseDTO<List<Product>> insertProductsIntoDatabase(@RequestBody List<Product> productList) {
        ResponseDTO<List<Product>> responseDTO;

        if (productList == null || productList.isEmpty()) {
            return new ResponseDTO<>("FAIL", null, "please add at-least one item to cart to proceed");
        } else {
            List<Product> productDump = productService.insertProductsIntoDatabase(productList);
            return new ResponseDTO<>("SUCCESS", null, "Data inserted successfully");
        }
    }
}
