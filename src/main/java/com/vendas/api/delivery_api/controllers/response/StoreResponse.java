package com.vendas.api.delivery_api.controllers.response;

public record StoreResponse (Long id,
                             String name,
                             String cnpj,
                             String phone,
                             Boolean active,
                             String storeRua){
}
