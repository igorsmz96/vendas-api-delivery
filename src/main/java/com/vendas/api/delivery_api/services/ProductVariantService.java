package com.vendas.api.delivery_api.services;

import com.vendas.api.delivery_api.controllers.requestCreate.ProductVariantRequest;
import com.vendas.api.delivery_api.controllers.requestPatch.ProductVariantPatchRequest;
import com.vendas.api.delivery_api.controllers.response.ProductVariantResponse;
import com.vendas.api.delivery_api.entities.Product;
import com.vendas.api.delivery_api.entities.ProductVariant;
import com.vendas.api.delivery_api.exception.DuplicateDataException;
import com.vendas.api.delivery_api.exception.ProductNotFoundException;
import com.vendas.api.delivery_api.exception.ProductVariantNotFoundException;
import com.vendas.api.delivery_api.mapper.ProductVariantMapper;
import com.vendas.api.delivery_api.repositories.ProductRepository;
import com.vendas.api.delivery_api.repositories.ProductVariantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductVariantService {
    private final ProductVariantRepository variantRepository;
    private final ProductRepository productRepository;
    private final ProductVariantMapper variantMapper;

    public ProductVariantResponse createVariant (Long productId, ProductVariantRequest variantRequest) {

        if(variantRepository.existsBySku(variantRequest.sku())){
            throw new DuplicateDataException("SKU já cadastrado");
        }
        Product product = productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
        ProductVariant productVariant = variantMapper.toProductVariant(variantRequest);
        productVariant.setProduct(product);
        variantRepository.save(productVariant);
        return variantMapper.toProductVariantResponse(productVariant);
    }

    public List<ProductVariantResponse> findVariantByProduct (Long productId) {
       productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
        List <ProductVariant> variants = variantRepository.findByProductId(productId);
        return variants.stream().map(variantMapper::toProductVariantResponse).toList();

    }

    public ProductVariantResponse updatePartial (Long productId, Long variantId, ProductVariantPatchRequest variantRequest ){
        productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);

        ProductVariant productVariant = variantRepository.findByIdAndProductId(variantId, productId)
                .orElseThrow(ProductVariantNotFoundException::new);

        Optional.ofNullable(variantRequest.size()).ifPresent(productVariant::setSize);
        Optional.ofNullable(variantRequest.color()).ifPresent(productVariant::setColor);
        Optional.ofNullable(variantRequest.sku()).ifPresent(sku -> {
            if(variantRepository.existsByIdNotAndSku(variantId, sku)){
                throw new DuplicateDataException("Sku já cadastrado");
            }
            productVariant.setSku(sku);
        });
        Optional.ofNullable(variantRequest.price()).ifPresent(productVariant::setPrice);

        variantRepository.save(productVariant);
        return variantMapper.toProductVariantResponse(productVariant);
    }

    public void deleteVariantById(Long productId, Long variantId){
        productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);

        ProductVariant productVariant = variantRepository.findByIdAndProductId(variantId, productId)
                .orElseThrow(ProductVariantNotFoundException::new);
        variantRepository.delete(productVariant);

    }

    public ProductVariantResponse updateVariantActive (Long productId, Long variantId, Boolean active){
        productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
        ProductVariant productVariant = variantRepository.findByIdAndProductId(variantId, productId)
                .orElseThrow(ProductVariantNotFoundException::new);
        productVariant.setActive(active);
        variantRepository.save(productVariant);
        return variantMapper.toProductVariantResponse(productVariant);
    }
}
