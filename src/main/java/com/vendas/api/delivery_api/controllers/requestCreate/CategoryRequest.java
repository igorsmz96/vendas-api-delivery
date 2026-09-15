package com.vendas.api.delivery_api.controllers.requestCreate;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(@NotBlank(message = "Nome é obrigatório") String name,
                             String description) {
}