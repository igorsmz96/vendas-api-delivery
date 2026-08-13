package com.vendas.api.delivery_api.repositories;

import com.vendas.api.delivery_api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {
}
