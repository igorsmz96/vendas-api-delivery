package com.vendas.api.delivery_api.mapper;

import com.vendas.api.delivery_api.controllers.request.StoreRequest;
import com.vendas.api.delivery_api.controllers.response.StoreResponse;
import com.vendas.api.delivery_api.entities.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreMapper {

    private final AddressMapper addressMapper;

    public Store toStore(StoreRequest storeRequest) {
        Store store = new Store();

        store.setName(storeRequest.name());
        store.setCnpj(storeRequest.cnpj());
        store.setPhone(storeRequest.phone());
        store.setActive(storeRequest.active());
        store.setAddress(addressMapper.toAddress(storeRequest.address()));


        return store;

    }

    public StoreResponse toResponse(Store store) {
        return new StoreResponse(store.getId(),
                store.getName(), store.getCnpj(), store.getPhone(), store.getActive(),store.getAddress().getRua());
    }
}
