package com.vendas.api.delivery_api.mapper;

import com.vendas.api.delivery_api.controllers.request.ProductRequest;
import com.vendas.api.delivery_api.controllers.response.ProductResponse;
import com.vendas.api.delivery_api.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequest productRequest) {
       Product product = new Product();

       product.setName(productRequest.name());
       product.setDescription(productRequest.description());
       product.setImgageUrl(productRequest.imgageUrl());
       product.setPrice(productRequest.price());
       product.setCategory(productRequest.categoryId());

       return product;
    }

    public ProductResponse toResponse (Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getImgageUrl(),
                product.getPrice(),
                product.getCategory().getName()
                );
    }

}
