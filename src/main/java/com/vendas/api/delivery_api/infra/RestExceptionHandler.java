package com.vendas.api.delivery_api.infra;

import com.vendas.api.delivery_api.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<ErroResposta> userNotFoundHandler(UserNotFoundException e) {
        ErroResposta erro = new ErroResposta(
                HttpStatus.NOT_FOUND.value(),
                "Recurso nao encontrado",
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(AddressNotFoundException.class)
    private ResponseEntity<ErroResposta> addressNotFoundHandler(AddressNotFoundException e) {
        ErroResposta erro = new ErroResposta(
                HttpStatus.NOT_FOUND.value(),
                "Recurso nao encontrado",
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    private ResponseEntity<ErroResposta> categoryNotFoundHandler(CategoryNotFoundException e) {
        ErroResposta erro = new ErroResposta(
                HttpStatus.NOT_FOUND.value(),
                "Recurso nao encontrado",
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ErroResposta> ProductNotFoundHandler(ProductNotFoundException e) {
        ErroResposta erro = new ErroResposta(
                HttpStatus.NOT_FOUND.value(),
                "Recurso nao encontrado",
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(StoreNotFoundException.class)
    private ResponseEntity<ErroResposta> storeNotFoundHandler(StoreNotFoundException e) {
        ErroResposta erro = new ErroResposta(
                HttpStatus.NOT_FOUND.value(),
                "Recurso nao encontrado",
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

    }
}