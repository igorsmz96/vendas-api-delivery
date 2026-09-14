package com.vendas.api.delivery_api.controllers.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequest(@NotBlank(message = "Nome é obrigatório") String name,
                             @NotBlank(message = "Marca é obrigatória") String marca,
                             @NotBlank(message = "Descrição é obrigatória") String description,
                             String imageUrl,
                             @NotNull(message = "Preço é obrigatório") BigDecimal price,
                             @NotNull(message = "Categoria é obrigatória") Long categoryId) {
}