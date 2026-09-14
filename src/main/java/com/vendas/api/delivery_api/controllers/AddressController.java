package com.vendas.api.delivery_api.controllers;

import com.vendas.api.delivery_api.controllers.request.AddressRequest;
import com.vendas.api.delivery_api.controllers.response.AddressResponse;
import com.vendas.api.delivery_api.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users/{userId}/address")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@PathVariable Long userId, @RequestBody AddressRequest addressRequest){
        AddressResponse addressResponse = addressService.createAddress(userId, addressRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressResponse);
    }
    @GetMapping
    public ResponseEntity<List<AddressResponse>> findAllByUser(@PathVariable Long userId){
        List<AddressResponse> addressResponse = addressService.findAllByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> findById(@PathVariable Long userId, @PathVariable("id") Long addressId){
        AddressResponse addressResponse = addressService.findAddressById(userId,addressId);
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
