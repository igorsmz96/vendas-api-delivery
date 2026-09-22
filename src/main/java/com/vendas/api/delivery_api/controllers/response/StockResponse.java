package com.vendas.api.delivery_api.controllers.response;

public record StockResponse(Long id,
                            String storeName,
                            String variantName,
                            Integer quantity) {
}
