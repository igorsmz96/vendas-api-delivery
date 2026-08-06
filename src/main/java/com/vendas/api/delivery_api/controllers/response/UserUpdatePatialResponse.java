package com.vendas.api.delivery_api.controllers.response;

public record UserUpdatePatialResponse(Long id,
                                       String name,
                                       String phone,
                                       String email) {
}
