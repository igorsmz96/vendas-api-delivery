package com.vendas.api.delivery_api.infra;

import com.vendas.api.delivery_api.exception.AddressNotFoundException;
import com.vendas.api.delivery_api.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

     @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<String> userNotFoundHandler(UserNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(AddressNotFoundException.class)
    private ResponseEntity<String> addressNotFoundHandler(AddressNotFoundException e){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}