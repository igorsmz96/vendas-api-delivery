package com.vendas.api.delivery_api.controllers.request;


import jakarta.validation.constraints.NotNull;

public record ActiveRequest(@NotNull(message = "O status é obrigatorio") Boolean active) {
}
