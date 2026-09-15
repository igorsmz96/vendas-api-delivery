package com.vendas.api.delivery_api.controllers.requestCreate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductVariantRequest(@NotBlank(message = "Tamanho é obrigatório") String size,
                                    @NotBlank(message = "Cor é obrigatória") String color,
                                    @NotBlank(message = "SKU é obrigatório") String sku,
                                    @NotNull(message = "Preço é obrigatório") BigDecimal price
) {
}