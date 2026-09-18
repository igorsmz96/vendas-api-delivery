package com.vendas.api.delivery_api.mapper;

import com.vendas.api.delivery_api.controllers.requestCreate.AddressRequest;
import com.vendas.api.delivery_api.controllers.requestPatch.AddressPatchRequest;
import com.vendas.api.delivery_api.controllers.response.AddressResponse;
import com.vendas.api.delivery_api.entities.Address;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    public void updatePartial (AddressPatchRequest addressPatchRequest, Address address){
        Optional.ofNullable(addressPatchRequest.cep()).ifPresent(address::setCep);
        Optional.ofNullable(addressPatchRequest.rua()).ifPresent(address::setRua);
        Optional.ofNullable(addressPatchRequest.numero()).ifPresent(address::setNumero);
        Optional.ofNullable(addressPatchRequest.bairro()).ifPresent(address::setBairro);
        Optional.ofNullable(addressPatchRequest.cidade()).ifPresent(address::setCidade);
    }
}

