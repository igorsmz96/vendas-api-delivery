package com.vendas.api.delivery_api.controllers.response;

import com.vendas.api.delivery_api.entities.Address;

import java.util.List;

public record UserResponse(Long id,
                           String name,
                           String phone,
                           String email,
                           List<AddressResponse> addresses) {
}
