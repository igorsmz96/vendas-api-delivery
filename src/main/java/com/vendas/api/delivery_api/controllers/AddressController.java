package com.vendas.api.delivery_api.controllers;

import com.vendas.api.delivery_api.controllers.request.AddressRequest;
import com.vendas.api.delivery_api.controllers.response.AddressResponse;
import com.vendas.api.delivery_api.repositories.AddressRepository;
import com.vendas.api.delivery_api.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final AddressRepository addressRepository;

    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@PathVariable Long userId, @RequestBody AddressRequest addressRequest){
        AddressResponse addressResponse = addressService.createAddress(userId, addressRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressResponse);
    }
    @GetMapping
    public ResponseEntity<List<AddressResponse>> findAllByUser(@PathVariable Long userId){
        List<AddressResponse> addressResponse = addressService.findByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> findById(@PathVariable Long userId, @PathVariable("id") Long addressId){
        AddressResponse addressResponse = addressService.findById(userId,addressId);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }
    @PatchMapping("/{id}")
   public ResponseEntity<AddressResponse> updatePartial( @PathVariable Long userId,@PathVariable("id") Long addressId, @RequestBody AddressRequest addressRequest){
       AddressResponse addressResponse = addressService.updatePartialAddress(userId,addressId,addressRequest);
    return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<AddressResponse> deleteById(@PathVariable Long userId, @PathVariable("id") Long addressId){
       addressService.deleteById(userId,addressId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }






}
