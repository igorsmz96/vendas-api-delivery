package com.vendas.api.delivery_api.exception;

public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException(){
        super("Endereço não encontrado");
    }
}
