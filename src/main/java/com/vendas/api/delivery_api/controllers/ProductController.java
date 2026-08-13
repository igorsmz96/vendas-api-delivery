package com.vendas.api.delivery_api.controllers;

import com.vendas.api.delivery_api.controllers.request.ProductRequest;
import com.vendas.api.delivery_api.controllers.response.ProductResponse;
import com.vendas.api.delivery_api.entities.Product;
import com.vendas.api.delivery_api.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.createProduct(productRequest);
                return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);

    }

    public ResponseEntity<List<ProductResponse>> findAllProducts(){
        List <ProductResponse> products = productService.findAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    public ResponseEntity<ProductResponse> findProductById(@PathVariable Long id){
        ProductResponse product = productService.findProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);

    }
    public ResponseEntity <ProductResponse> updateProductPartial(@PathVariable Long id, @RequestBody ProductRequest productRequest){
        ProductResponse product = productService.updateProductPartial(id,productRequest)
    }

    public ResponseEntity<ProductResponse> deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
