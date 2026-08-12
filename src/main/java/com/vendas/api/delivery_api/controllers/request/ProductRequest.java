package com.vendas.api.delivery_api.controllers.request;

import com.vendas.api.delivery_api.entities.Category;

import java.math.BigDecimal;

public record ProductRequest(String name,
                             String description,
                             String imgageUrl,
                             BigDecimal price,
                             Category categoryId) {
}
