package com.vendas.api.delivery_api.controllers.request;

import java.util.List;

public record UserRequest(String name,
                          String phone,
                          String email,
                          String password,
                          List<AddressRequest> adresses) {

}
