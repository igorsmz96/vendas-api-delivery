package com.vendas.api.delivery_api.controllers;

import com.vendas.api.delivery_api.controllers.requestCreate.ActiveRequest;
import com.vendas.api.delivery_api.controllers.requestCreate.ProductVariantRequest;
import com.vendas.api.delivery_api.controllers.requestPatch.ProductVariantPatchRequest;
import com.vendas.api.delivery_api.controllers.response.ProductVariantResponse;
import com.vendas.api.delivery_api.services.ProductVariantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product/{productId}/variants")
public class ProductVariantController {

    private final ProductVariantService variantService;

    @PostMapping
    public ResponseEntity<ProductVariantResponse> createVariant(@PathVariable Long productId,
                                                                @Valid @RequestBody ProductVariantRequest productVariantRequest) {
        ProductVariantResponse variant = variantService.createVariant(productId,productVariantRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(variant);

    }

    @GetMapping()
    public ResponseEntity<List<ProductVariantResponse>> findVariantByProduct(@PathVariable Long productId) {
        List<ProductVariantResponse> variants = variantService.findVariantByProduct(productId);
        return ResponseEntity.status(HttpStatus.OK).body(variants);
    }

    @PatchMapping("/{variantId}")
    public ResponseEntity<ProductVariantResponse> updatePartial(@PathVariable Long productId, @PathVariable Long variantId,@Valid @RequestBody ProductVariantPatchRequest request  ) {
        ProductVariantResponse variant = variantService.updatePartial(productId,variantId,request);
        return ResponseEntity.status(HttpStatus.OK).body(variant);
    }

    @PatchMapping("/{variantId}/active")
    public ResponseEntity<ProductVariantResponse> updateVariantActive(@PathVariable Long productId, @PathVariable Long variantId, @Valid @RequestBody ActiveRequest activeRequest) {
        ProductVariantResponse variantResponse = variantService.updateVariantActive(productId,variantId,activeRequest.active());
        return ResponseEntity.status(HttpStatus.OK).body(variantResponse);

    }

    @DeleteMapping("/{variantId}")
    public ResponseEntity<Void> deleteVariant(@PathVariable Long productId, @PathVariable Long variantId) {
        variantService.deleteVariantById(productId, variantId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
