package com.vendas.api.delivery_api.controllers.request;

import java.math.BigDecimal;

public record ProductRequest(String name,
                             String marca,
                             String description,
                             String imageUrl,
                             BigDecimal price,
                             Long categoryId,
                             Boolean active) {
}
