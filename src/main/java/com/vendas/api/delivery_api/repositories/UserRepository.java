package com.vendas.api.delivery_api.repositories;

import com.vendas.api.delivery_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    Optional<User> findUserByEmail(String email);
    Boolean existsByEmail(String email);
}
