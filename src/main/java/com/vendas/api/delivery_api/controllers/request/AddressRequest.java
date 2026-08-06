package com.vendas.api.delivery_api.controllers.request;

public record AddressRequest(String cep,
                             String rua,
                             String numero,
                             String bairro,
                             String cidade,
                             Double longitude,
                             Double latitude) {
}
