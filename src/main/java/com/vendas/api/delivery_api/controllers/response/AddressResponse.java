package com.vendas.api.delivery_api.controllers.response;

public record AddressResponse(String cep,
                              String rua,
                              String numero,
                              String bairro,
                              String cidade
                              ) {
}
