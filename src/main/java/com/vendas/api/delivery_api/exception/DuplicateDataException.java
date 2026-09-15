package com.vendas.api.delivery_api.exception;

public class DuplicateDataException extends  RuntimeException {

    public DuplicateDataException(String message) {
        super(message);
    }
}
