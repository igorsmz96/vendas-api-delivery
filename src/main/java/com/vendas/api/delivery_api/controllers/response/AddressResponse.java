package com.vendas.api.delivery_api.controllers.response;

public record AddressResponse(Long id,
                              String cep,
                              String rua,
                              String numero,
                              String bairro,
                              String cidade
                              ) {
}
