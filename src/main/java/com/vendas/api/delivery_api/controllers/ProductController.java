package com.vendas.api.delivery_api.controllers;

import com.vendas.api.delivery_api.controllers.request.ProductRequest;
import com.vendas.api.delivery_api.controllers.response.ProductResponse;
import com.vendas.api.delivery_api.services.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.createProduct(productRequest);
                return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);

    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAllProducts(){
        List <ProductResponse> products = productService.findAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable Long id){
        ProductResponse product = productService.findProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);

    }
    @PatchMapping("/{id}")
    public ResponseEntity <ProductResponse> updateProductPartial(@PathVariable Long id, @RequestBody ProductRequest productRequest){
        ProductResponse product = productService.updateProductPartial(id,productRequest);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductResponse>> findProductsByCategory(@PathVariable Long categoryId){
        List <ProductResponse> products = productService.findProductsByCategory(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(products);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
