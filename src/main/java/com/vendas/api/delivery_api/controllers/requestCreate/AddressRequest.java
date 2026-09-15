package com.vendas.api.delivery_api.controllers.requestCreate;

import jakarta.validation.constraints.NotBlank;

public record AddressRequest(@NotBlank(message = "CEP é obrigatório") String cep,
                             @NotBlank(message = "Rua é obrigatória") String rua,
                             @NotBlank(message = "Número é obrigatório") String numero,
                             @NotBlank(message = "Bairro é obrigatório") String bairro,
                             @NotBlank(message = "Cidade é obrigatória") String cidade) {
}