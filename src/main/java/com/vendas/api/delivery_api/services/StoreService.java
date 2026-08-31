package com.vendas.api.delivery_api.services;

import com.vendas.api.delivery_api.controllers.request.StoreRequest;
import com.vendas.api.delivery_api.controllers.response.StoreResponse;
import com.vendas.api.delivery_api.entities.Address;
import com.vendas.api.delivery_api.entities.Store;
import com.vendas.api.delivery_api.exception.StoreNotFoundException;
import com.vendas.api.delivery_api.mapper.AddressMapper;
import com.vendas.api.delivery_api.mapper.StoreMapper;
import com.vendas.api.delivery_api.repositories.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;
    private final AddressMapper addressMapper;

    public StoreResponse createStore (StoreRequest storeRequest) {
        Store store = storeMapper.toStore(storeRequest);
        storeRepository.save(store);

        return storeMapper.toResponse(store);
    }

    public List<StoreResponse> findAllStores(){
        List<Store> stores = storeRepository.findAll();

        return stores.stream().map(storeMapper::toResponse).toList();
    }

    public StoreResponse findById(Long id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(StoreNotFoundException::new);

        return storeMapper.toResponse(store);
    }

    public StoreResponse updatePartialStore(Long id, StoreRequest storeRequest) {
        Store store = storeRepository.findById(id)
                .orElseThrow(StoreNotFoundException::new);

        Optional.ofNullable(storeRequest.name()).ifPresent(store::setName);
        Optional.ofNullable(storeRequest.cnpj()).ifPresent(store::setCnpj);
        Optional.ofNullable(storeRequest.phone()).ifPresent(store::setPhone);
        Optional.ofNullable(storeRequest.active()).ifPresent(store::setActive);
        Optional.ofNullable(storeRequest.address()).ifPresent(addressRequest -> {
           Address address =  addressMapper.toAddress(addressRequest);
            store.setAddress(address);
        } );
        storeRepository.save(store);
        return storeMapper.toResponse(store);
    }

    public void deleteStore(Long id){
        Store store = storeRepository.findById(id)
                .orElseThrow(StoreNotFoundException::new);
        storeRepository.delete(store);
    }




}
