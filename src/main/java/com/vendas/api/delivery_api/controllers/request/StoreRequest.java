package com.vendas.api.delivery_api.controllers.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StoreRequest(@NotBlank(message = "Nome é obrigatório") String name,
                           @NotBlank(message = "CNPJ é obrigatório") String cnpj,
                           @NotBlank(message = "Telefone é obrigatório") String phone,
                           @NotNull(message = "Endereço é obrigatório") @Valid AddressRequest address) {
}