package com.vendas.api.delivery_api.mapper;

import com.vendas.api.delivery_api.controllers.request.ProductVariantRequest;
import com.vendas.api.delivery_api.controllers.response.ProductVariantResponse;
import com.vendas.api.delivery_api.entities.ProductVariant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductVariantMapper {
    private final ProductMapper productMapper;

    public ProductVariant toProductVariant(ProductVariantRequest productVariantRequest) {
        ProductVariant productVariant = new ProductVariant();

        productVariant.setSize(productVariantRequest.size());
        productVariant.setColor(productVariantRequest.color());
        productVariant.setSku(productVariantRequest.sku());
        productVariant.setPrice(productVariantRequest.price());
        productVariant.setActive(productVariantRequest.active());

        return productVariant;

    }

    public ProductVariantResponse toProductVariantResponse(ProductVariant productVariant) {
        return new ProductVariantResponse(
                productVariant.getId(),
                productVariant.getSize(),
                productVariant.getColor(),
                productVariant.getSku(),
                productVariant.getPrice(),
                productVariant.getActive());
    }
}
