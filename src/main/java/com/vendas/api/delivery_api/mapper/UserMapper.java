package com.vendas.api.delivery_api.mapper;

import com.vendas.api.delivery_api.controllers.request.AddressRequest;
import com.vendas.api.delivery_api.controllers.request.UserRequest;
import com.vendas.api.delivery_api.entities.Address;
import com.vendas.api.delivery_api.entities.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserMapper {

    private final AddressMapper addressMapper;

    public User toUser(UserRequest userRequest){
        User user = new User();

        user.setName(userRequest.name());
        user.setPhone(userRequest.phone());
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());

        if (userRequest.adresses() != null){

            for (AddressRequest ar : userRequest.adresses()){
                Address address = addressMapper.toAddress(ar);

                user.getAddresses().add(address);
                address.setUser(user);




            }



        }
        return user;

    }
}
