package com.vendas.api.delivery_api.exception;

public class ProductVariantNotFoundException extends RuntimeException {

    public ProductVariantNotFoundException() {
        super("Product variant not found");
    }
}
