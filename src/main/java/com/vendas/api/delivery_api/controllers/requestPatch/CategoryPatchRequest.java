package com.vendas.api.delivery_api.controllers.requestPatch;

public record CategoryPatchRequest(
        String name,
        String description
) {
}