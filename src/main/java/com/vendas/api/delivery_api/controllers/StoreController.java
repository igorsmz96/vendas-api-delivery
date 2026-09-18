package com.vendas.api.delivery_api.controllers;


import com.vendas.api.delivery_api.controllers.requestCreate.ActiveRequest;
import com.vendas.api.delivery_api.controllers.requestCreate.StoreRequest;
import com.vendas.api.delivery_api.controllers.requestPatch.StorePatchRequest;
import com.vendas.api.delivery_api.controllers.response.StoreResponse;
import com.vendas.api.delivery_api.services.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<StoreResponse> createStore(@Valid @RequestBody StoreRequest storeRequest){
        StoreResponse storeResponse = storeService.createStore(storeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(storeResponse);
    }

    @GetMapping
    public ResponseEntity<List<StoreResponse>> findAllStores(){

        List<StoreResponse  > storeResponse = storeService.findAllStores();
        return ResponseEntity.status(HttpStatus.OK).body(storeResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreResponse> findById(@PathVariable Long id){
        StoreResponse storeResponse = storeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(storeResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StoreResponse> updatePartialStore(@PathVariable Long id, @Valid @RequestBody StorePatchRequest storePatchRequest){
        StoreResponse storeResponse = storeService.updatePartialStore(id, storePatchRequest);
        return ResponseEntity.status(HttpStatus.OK).body(storeResponse);
    }
    @PatchMapping("/{id}/active")
    public ResponseEntity<StoreResponse> updateStoreActive(@PathVariable Long id, @Valid @RequestBody ActiveRequest activeRequest){
        StoreResponse storeResponse = storeService.updateStoreActive(id, activeRequest.active());
        return ResponseEntity.status(HttpStatus.OK).body(storeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id){
        storeService.deleteStore(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
