package com.vendas.api.delivery_api.controllers.requestPatch;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductVariantPatchRequest(
        String size,
        String color,
        String sku,
        @Positive BigDecimal price
) {
}