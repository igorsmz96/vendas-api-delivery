package com.vendas.api.delivery_api.exception;

public class StockNotFoundException extends RuntimeException{

    public StockNotFoundException (){
        super("Stock not found");
    }
}
