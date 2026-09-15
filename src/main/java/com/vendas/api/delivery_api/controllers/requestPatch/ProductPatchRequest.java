package com.vendas.api.delivery_api.controllers.requestPatch;

import java.math.BigDecimal;

public record ProductPatchRequest(
        String name,
        String marca,
        String description,
        String imageUrl,
        BigDecimal price,
        Long categoryId
) {
}