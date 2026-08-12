package com.vendas.api.delivery_api.exception;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException() {
        super("Categoria não encontrada");
    }
}
