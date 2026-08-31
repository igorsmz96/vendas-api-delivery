package com.vendas.api.delivery_api.services;

import com.vendas.api.delivery_api.controllers.request.ProductVariantRequest;
import com.vendas.api.delivery_api.controllers.response.ProductVariantResponse;
import com.vendas.api.delivery_api.entities.Product;
import com.vendas.api.delivery_api.entities.ProductVariant;
import com.vendas.api.delivery_api.exception.ProductNotFoundException;
import com.vendas.api.delivery_api.mapper.ProductVariantMapper;
import com.vendas.api.delivery_api.repositories.ProductRepository;
import com.vendas.api.delivery_api.repositories.ProductVariantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductVariantService {
    private final ProductVariantRepository variantRepository;
    private final ProductRepository productRepository;
    private final ProductVariantMapper variantMapper;

    public ProductVariantResponse createVariant (Long productId, ProductVariantRequest variantRequest) {
        Product product = productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
        ProductVariant productVariant = variantMapper.toProductVariant(variantRequest);
        productVariant.setProduct(product);
        variantRepository.save(productVariant);
        return variantMapper.toProductVariantResponse(productVariant);
    }

    public List<ProductVariantResponse> findVariantByProduct (Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
        List <ProductVariant> variants = variantRepository.findByProductId(productId);
        return variants.stream().map(variantMapper::toProductVariantResponse).toList();

    }
}
