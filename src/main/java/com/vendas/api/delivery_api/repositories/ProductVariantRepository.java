package com.vendas.api.delivery_api.repositories;

import com.vendas.api.delivery_api.entities.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {

    List<ProductVariant> findByProductId(Long productId);
}
