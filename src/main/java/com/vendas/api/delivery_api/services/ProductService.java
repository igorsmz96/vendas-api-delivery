package com.vendas.api.delivery_api.services;

import com.vendas.api.delivery_api.controllers.request.ProductRequest;
import com.vendas.api.delivery_api.controllers.response.ProductResponse;
import com.vendas.api.delivery_api.entities.Product;
import com.vendas.api.delivery_api.exception.ProductNotFoundException;
import com.vendas.api.delivery_api.mapper.ProductMapper;
import com.vendas.api.delivery_api.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = productMapper.toProduct(productRequest);
        product = productRepository.save(product);

        return productMapper.toResponse(product);
    }

    public List<ProductResponse> findAllProducts(){
        List <Product> allProducts = productRepository.findAll();
        return   allProducts.stream().map(productMapper::toResponse).toList();

    }

    public ProductResponse findProductById (Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        return productMapper.toResponse(product);
    }





}
