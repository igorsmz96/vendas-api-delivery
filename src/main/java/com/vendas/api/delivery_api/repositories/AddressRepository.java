package com.vendas.api.delivery_api.repositories;

import com.vendas.api.delivery_api.entities.Address;
import com.vendas.api.delivery_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserId(Long userId);
    Optional<Address> findByIdAndUserId(Long addressId,Long userId);
}
