package com.vendas.api.delivery_api.controllers;

import com.vendas.api.delivery_api.controllers.request.ProductVariantRequest;
import com.vendas.api.delivery_api.controllers.response.ProductVariantResponse;
import com.vendas.api.delivery_api.services.ProductVariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product/{productsId}/variants")
public class ProductVariantController {

    private final ProductVariantService productVariantService;

    @PostMapping
    public ResponseEntity<ProductVariantResponse> createVariant(@PathVariable Long productsId,
                                                                @RequestBody ProductVariantRequest productVariantRequest) {
        ProductVariantResponse variant = productVariantService.createVariant(productsId,productVariantRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(variant);

    }

    @GetMapping
    public ResponseEntity<List<ProductVariantResponse>> findVariantByProduct(@PathVariable Long productsId) {
        List<ProductVariantResponse> variants = productVariantService.findVariantByProduct(productsId);
        return ResponseEntity.status(HttpStatus.OK).body(variants);
    }
}
