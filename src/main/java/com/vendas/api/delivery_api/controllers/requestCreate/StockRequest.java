package com.vendas.api.delivery_api.controllers.requestCreate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record StockRequest(@NotNull Long store_id,
                           @NotNull Long product_variant_id,
                           @Min(0) Integer quantity) {
}
