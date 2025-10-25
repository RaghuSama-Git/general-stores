package com.product.general_stores.util;

import org.springframework.stereotype.Component;

@Component
public class ResponseDTO<T> {

    private String status;
    private T data;
    private String message;

    public ResponseDTO(String status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    //GETTERS AND SETTERS
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseDTO() {

    }

}
