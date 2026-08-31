package com.vendas.api.delivery_api.controllers;


import com.vendas.api.delivery_api.controllers.request.StoreRequest;
import com.vendas.api.delivery_api.controllers.response.StoreResponse;
import com.vendas.api.delivery_api.services.StoreService;
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
    public ResponseEntity<StoreResponse> createStore(@RequestBody StoreRequest storeRequest){
        StoreResponse storeResponse = storeService.createStore(storeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(storeResponse);
    }

    @GetMapping
    public ResponseEntity<List<StoreResponse>> findAllStores(){
        List<StoreResponse> storeResponse = storeService.findAllStores();
        return ResponseEntity.status(HttpStatus.OK).body(storeResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreResponse> findById(@PathVariable Long id){
        StoreResponse storeResponse = storeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(storeResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StoreResponse> updatePartialStore(@PathVariable Long id, @RequestBody StoreRequest storeRequest){
        StoreResponse storeResponse = storeService.updatePartialStore(id, storeRequest);
        return ResponseEntity.status(HttpStatus.OK).body(storeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StoreResponse> deleteStore(@PathVariable Long id){
        storeService.deleteStore(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
