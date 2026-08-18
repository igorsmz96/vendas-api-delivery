package com.vendas.api.delivery_api.repositories;

import com.vendas.api.delivery_api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long> {

    public List<Product> findByCategoryId(Long id);
}
