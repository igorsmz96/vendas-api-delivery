package com.vendas.api.delivery_api.controllers.request;



public record StoreRequest(String name,
                           String cnpj,
                           String phone,
                           Boolean active,
                           AddressRequest address) {
}
