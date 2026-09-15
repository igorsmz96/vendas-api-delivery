package com.vendas.api.delivery_api.controllers.requestCreate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserRequest(@NotBlank(message = "Nome é obrigatório") String name,
                          @NotBlank(message = "Telefone é obrigatório") @Pattern(regexp = "\\d{10,11}", message = "Telefone inválido") String phone,
                          @NotBlank(message = "Email é obrigatório") @Email(message = "Email inválido") String email,
                          @NotBlank(message = "Senha é obrigatória") String password) {
}