package com.vendas.api.delivery_api.services;

import com.vendas.api.delivery_api.controllers.request.ProductRequest;
import com.vendas.api.delivery_api.controllers.response.ProductResponse;
import com.vendas.api.delivery_api.entities.Category;
import com.vendas.api.delivery_api.entities.Product;
import com.vendas.api.delivery_api.exception.CategoryNotFoundException;
import com.vendas.api.delivery_api.exception.ProductNotFoundException;
import com.vendas.api.delivery_api.mapper.ProductMapper;
import com.vendas.api.delivery_api.repositories.CategoryRepository;
import com.vendas.api.delivery_api.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Category category = categoryRepository.findById(productRequest.categoryId())
                .orElseThrow(CategoryNotFoundException::new);


        Product product = productMapper.toProduct(productRequest);
        product.setCategory(category);
        product = productRepository.save(product);

        return productMapper.toResponse(product);
    }

    public List<ProductResponse> findAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream().map(productMapper::toResponse).toList();

    }

    public ProductResponse findProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        return productMapper.toResponse(product);
    }

    public List<ProductResponse> findProductsByCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        List <Product> productList = productRepository.findByCategoryId(id);

        return productList.stream().map(productMapper::toResponse).toList();

    }

    public ProductResponse updateProductPartial(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        Optional.ofNullable(productRequest.name()).ifPresent(product::setName);
        Optional.ofNullable(productRequest.description()).ifPresent(product::setDescription);
        Optional.ofNullable(productRequest.imageUrl()).ifPresent(product::setImageUrl);
        Optional.ofNullable(productRequest.price()).ifPresent(product::setPrice);
        Optional.ofNullable(productRequest.categoryId()).ifPresent(categoryId -> {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(CategoryNotFoundException::new);
            product.setCategory(category);
        });

        productRepository.save(product);
        return productMapper.toResponse(product);
    }

    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        productRepository.delete(product);
    }


}
