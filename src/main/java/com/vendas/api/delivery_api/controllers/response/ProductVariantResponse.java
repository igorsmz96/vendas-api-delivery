package com.vendas.api.delivery_api.controllers.response;


import java.math.BigDecimal;

public record ProductVariantResponse(Long id,
                                     String size,
                                     String color,
                                     String sku,
                                     BigDecimal price,
                                     Boolean active
                                     ) {
}
