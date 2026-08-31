package com.vendas.api.delivery_api.repositories;

import com.vendas.api.delivery_api.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
