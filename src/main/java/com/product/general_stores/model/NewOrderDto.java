package com.product.general_stores.model;

import java.time.LocalDateTime;
import java.util.List;

public class NewOrderDto {
    private String email;
    private List<Product> productList;
    private LocalDateTime dateTime;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
