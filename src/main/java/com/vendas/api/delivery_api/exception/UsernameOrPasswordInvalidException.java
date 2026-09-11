package com.vendas.api.delivery_api.exception;

public class UsernameOrPasswordInvalidException extends RuntimeException {

    public UsernameOrPasswordInvalidException() {
        super("Usuario ou senha invalidos");
    }
}
