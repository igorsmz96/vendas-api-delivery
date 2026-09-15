package com.vendas.api.delivery_api.controllers.requestPatch;

import jakarta.validation.Valid;

public record StorePatchRequest(
        String name,
        String cnpj,
        String phone,
        @Valid AddressPatchRequest address
) {
}