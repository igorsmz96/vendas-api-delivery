package com.vendas.api.delivery_api.controllers.response;

import com.vendas.api.delivery_api.config.Role;

public record UserResponse(Long id,
                           String name,
                           String phone,
                           String email,
                           Role role) {
}
