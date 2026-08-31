package com.vendas.api.delivery_api.mapper;

import com.vendas.api.delivery_api.controllers.request.AddressRequest;
import com.vendas.api.delivery_api.controllers.response.AddressResponse;
import com.vendas.api.delivery_api.entities.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toAddress (AddressRequest addressRequest){

      Address address = new Address();

        address.setCep(addressRequest.cep());
        address.setRua(addressRequest.rua());
        address.setNumero(addressRequest.numero());
        address.setBairro(addressRequest.bairro());
        address.setCidade(addressRequest.cidade());

        return address;

    }

    public AddressResponse ToResponse(Address address){
        if (address == null) return null;


        return new AddressResponse(address.getId(),
                address.getCep(),
                address.getRua(),
                address.getNumero(),
                address.getBairro(),
                address.getCidade());
    }
}

