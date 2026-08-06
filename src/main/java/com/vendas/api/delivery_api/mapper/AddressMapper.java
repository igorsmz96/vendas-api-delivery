package com.vendas.api.delivery_api.mapper;

import com.vendas.api.delivery_api.controllers.request.AddressRequest;
import com.vendas.api.delivery_api.entities.Address;

public record AddressMapper() {

    public Address toAddress (AddressRequest addressRequest){

      Address address = new Address();

        address.setCep(addressRequest.cep());
        address.setRua(addressRequest.rua());
        address.setNumero(addressRequest.numero());
        address.setBairro(addressRequest.bairro());

        return address;

    }
}

