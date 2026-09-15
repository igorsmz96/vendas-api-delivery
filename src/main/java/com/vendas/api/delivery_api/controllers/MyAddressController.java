package com.vendas.api.delivery_api.controllers;

import com.vendas.api.delivery_api.controllers.requestCreate.AddressRequest;
import com.vendas.api.delivery_api.controllers.response.AddressResponse;
import com.vendas.api.delivery_api.entities.User;
import com.vendas.api.delivery_api.services.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/me/address")
@RequiredArgsConstructor
public class MyAddressController {



        private final AddressService addressService;

        @PostMapping
        public ResponseEntity<AddressResponse> createAddress(@AuthenticationPrincipal User userAuth, @Valid @RequestBody AddressRequest addressRequest){
            AddressResponse addressResponse = addressService.createAddress(userAuth.getId(), addressRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(addressResponse);
        }
        @GetMapping
        public ResponseEntity<List<AddressResponse>> findAllByUser(@AuthenticationPrincipal User userAuth){
            List<AddressResponse> addressResponse = addressService.findAllByUserId(userAuth.getId());
            return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
        }

        @GetMapping("/{id}")
        public ResponseEntity<AddressResponse> findById(@AuthenticationPrincipal User userAuth, @PathVariable("id") Long addressId){
            AddressResponse addressResponse = addressService.findAddressById(userAuth.getId(),addressId);
            return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
        }
        @PatchMapping("/{id}")
        public ResponseEntity<AddressResponse> updatePartial(@AuthenticationPrincipal User userAuth ,@PathVariable("id") Long addressId, @Valid @RequestBody AddressRequest addressRequest){
            AddressResponse addressResponse = addressService.updatePartialAddress(userAuth.getId(),addressId,addressRequest);
            return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<AddressResponse> deleteById(@AuthenticationPrincipal User userAuth, @PathVariable("id") Long addressId){
            addressService.deleteById(userAuth.getId(), addressId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }
