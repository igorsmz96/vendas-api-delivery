package com.vendas.api.delivery_api.controllers.requestPatch;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductPatchRequest(
        String name,
        String marca,
        String description,
        String imageUrl,
        @Positive BigDecimal price,
        Long categoryId
) {
}