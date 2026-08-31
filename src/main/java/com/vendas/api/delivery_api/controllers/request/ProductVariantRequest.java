package com.vendas.api.delivery_api.controllers.request;

import java.math.BigDecimal;

public record ProductVariantRequest(String size,
                                    String color,
                                    String sku,
                                    BigDecimal price,
                                    Boolean active

) {
}
