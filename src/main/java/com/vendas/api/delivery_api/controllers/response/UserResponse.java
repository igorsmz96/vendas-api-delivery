package com.vendas.api.delivery_api.controllers.response;

public record UserResponse(Long id,
                           String name,
                           String phone,
                           String email) {
}
