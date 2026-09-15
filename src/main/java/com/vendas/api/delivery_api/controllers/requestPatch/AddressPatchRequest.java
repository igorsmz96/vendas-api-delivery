package com.vendas.api.delivery_api.controllers.requestPatch;

public record AddressPatchRequest(
        String cep,
        String rua,
        String numero,
        String bairro,
        String cidade
) {}
