package com.vendas.api.delivery_api.repositories;

import com.vendas.api.delivery_api.entities.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress, Long> {
}
