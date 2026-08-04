package com.vendas.api.delivery_api.services;

import com.vendas.api.delivery_api.entities.User;
import com.vendas.api.delivery_api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {

        return userRepository.save(user);
    }
}
