package com.vendas.api.delivery_api.controllers.response;

public record StockTotalResponse(Long variantId,
                                 Long totalQuantity) {
}
