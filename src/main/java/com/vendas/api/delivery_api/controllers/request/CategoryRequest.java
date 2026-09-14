package com.vendas.api.delivery_api.controllers.request;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(@NotBlank(message = "Nome é obrigatório") String name,
                             String description) {
}