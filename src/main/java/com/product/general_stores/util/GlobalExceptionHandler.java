package com.product.general_stores.util;

import com.product.general_stores.exception.InvalidCredentialsException;
import com.product.general_stores.exception.UserAlreadyExistsException;
import com.product.general_stores.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ResponseDTO<Object>> handleUserAlreadyExistsException(UserAlreadyExistsException exception){
        ResponseDTO<Object> response = new ResponseDTO<>();

        response.setData(null);
        response.setStatus("FAIL");
        response.setMessage(exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseDTO<Object>> handleUserNotFoundException(UserNotFoundException exception){
        ResponseDTO<Object> response = new ResponseDTO<>();

        response.setData(null);
        response.setStatus("FAIL");
        response.setMessage(exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ResponseDTO<Object>> handleInvalidCredentialsException(InvalidCredentialsException exception){
        ResponseDTO<Object> response = new ResponseDTO<>();

        response.setData(null);
        response.setStatus("FAIL");
        response.setMessage(exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
