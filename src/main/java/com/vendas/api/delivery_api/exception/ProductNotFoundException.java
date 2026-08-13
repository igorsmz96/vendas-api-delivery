package com.vendas.api.delivery_api.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(){
        super("Produto não encontrado");
    }

}
