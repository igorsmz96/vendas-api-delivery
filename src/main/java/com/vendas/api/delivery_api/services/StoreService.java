package com.vendas.api.delivery_api.services;

import com.vendas.api.delivery_api.controllers.requestCreate.StoreRequest;
import com.vendas.api.delivery_api.controllers.requestPatch.StorePatchRequest;
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

    public StoreResponse updatePartialStore(Long id, StorePatchRequest storePatchRequest) {
        Store store = storeRepository.findById(id)
                .orElseThrow(StoreNotFoundException::new);

        Optional.ofNullable(storePatchRequest.name()).ifPresent(store::setName);
        Optional.ofNullable(storePatchRequest.cnpj()).ifPresent(store::setCnpj);
        Optional.ofNullable(storePatchRequest.phone()).ifPresent(store::setPhone);

        Optional.ofNullable(storePatchRequest.address()).ifPresent(addressPatchRequest ->
                addressMapper.updatePartial(addressPatchRequest, store.getAddress()));

        storeRepository.save(store);
        return storeMapper.toResponse(store);
    }

    public void deleteStore(Long id){
        Store store = storeRepository.findById(id)
                .orElseThrow(StoreNotFoundException::new);
        storeRepository.delete(store);
    }

    public StoreResponse updateStoreActive (Long id, Boolean active) {
        Store store = storeRepository.findById(id)
                .orElseThrow(StoreNotFoundException::new);
        store.setActive(active);
        storeRepository.save(store);
        return storeMapper.toResponse(store);
    }




}
