package com.vendas.api.delivery_api.services;

import com.vendas.api.delivery_api.controllers.request.AddressRequest;
import com.vendas.api.delivery_api.controllers.response.AddressResponse;
import com.vendas.api.delivery_api.entities.Address;
import com.vendas.api.delivery_api.entities.User;
import com.vendas.api.delivery_api.exception.AddressNotFoundException;
import com.vendas.api.delivery_api.exception.UserNotFoundException;
import com.vendas.api.delivery_api.mapper.AddressMapper;
import com.vendas.api.delivery_api.repositories.AddressRepository;
import com.vendas.api.delivery_api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final UserRepository userRepository;

    public AddressResponse createAddress (Long userId ,AddressRequest addressRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        Address address = addressMapper.toAddress(addressRequest);
        address.setUser(user);
        addressRepository.save(address);
        return addressMapper.ToResponse(address);
    }

    public List<AddressResponse> findByUserId (Long userId) {
       userRepository.findById(userId)
               .orElseThrow(UserNotFoundException::new);

       List <Address> addresses = addressRepository.findByUserId(userId);
       return  addresses.stream().map(addressMapper::ToResponse).toList();
    }

    public AddressResponse findById (long userId, Long addressId) {
        userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
        Address address = addressRepository.findById(addressId)
                .orElseThrow(AddressNotFoundException::new);

        return addressMapper.ToResponse(address);
    }

    public AddressResponse updatePartialAddress (Long id, AddressRequest addressRequest) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException());

        Optional.ofNullable(addressRequest.cep()).ifPresent(address::setCep);
        Optional.ofNullable(addressRequest.rua()).ifPresent(address::setRua);
        Optional.ofNullable(addressRequest.numero()).ifPresent(address::setNumero);
        Optional.ofNullable(addressRequest.bairro()).ifPresent(address::setBairro);
        Optional.ofNullable(addressRequest.cidade()).ifPresent(address::setCidade);

       addressRepository.save(address);
       return addressMapper.ToResponse(address);
    }


}
