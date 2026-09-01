package com.vendas.api.delivery_api.controllers.response;

import java.math.BigDecimal;

public record ProductResponse(Long id,
                              String name,
                              String marca,
                              String description,
                              String imageUrl,
                              BigDecimal price,
                              String categoryName,
                              Boolean active) {
}
