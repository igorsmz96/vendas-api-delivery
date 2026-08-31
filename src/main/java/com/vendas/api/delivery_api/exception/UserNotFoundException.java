package com.vendas.api.delivery_api.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){

        super("Usuario  não encontrado");
    }

    public UserNotFoundException(Long id){

        super("Usuario " +id +" não encontrado");
    }



}
