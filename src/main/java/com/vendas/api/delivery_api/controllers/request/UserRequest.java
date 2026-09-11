package com.vendas.api.delivery_api.controllers.request;

import com.vendas.api.delivery_api.config.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UserRequest(String name,
                          @Pattern(regexp = "\\d{10,11}", message = "Telefone inválido")String phone,
                          @Email(message = "Email invalido") String email,
                          @Size(min = 8, max = 25, message = "Senha deve ter entre 8 e 25 digitos")String password
                          ) {

}
