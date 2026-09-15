package com.vendas.api.delivery_api.controllers.requestPatch;

import java.math.BigDecimal;

public record ProductVariantPatchRequest(
        String size,
        String color,
        String sku,
        BigDecimal price
) {
}