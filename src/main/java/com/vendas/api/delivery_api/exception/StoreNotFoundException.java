package com.vendas.api.delivery_api.exception;

public class StoreNotFoundException extends RuntimeException {

    public StoreNotFoundException() {
        super("Store não encontrado");
    }
}
