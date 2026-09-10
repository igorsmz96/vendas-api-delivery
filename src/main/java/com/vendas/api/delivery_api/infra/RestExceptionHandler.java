package com.vendas.api.delivery_api.infra;

import com.vendas.api.delivery_api.exception.*;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

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

   /* @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        List<String> erros = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .toList();

        ErroResposta erro = new ErroResposta(
                HttpStatus.BAD_REQUEST.value(),
                erros,
                "recurso invalido"


        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

    }
*/
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