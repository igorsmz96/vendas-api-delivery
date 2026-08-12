package com.vendas.api.delivery_api.controllers.response;

import java.math.BigDecimal;

public record ProductResponse(Long id,
                              String name,
                              String description,
                              String imgageUrl,
                              BigDecimal price,
                              String categoryName) {
}
