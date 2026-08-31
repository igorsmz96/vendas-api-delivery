package com.vendas.api.delivery_api.mapper;

import com.vendas.api.delivery_api.controllers.request.AddressRequest;
import com.vendas.api.delivery_api.controllers.request.UserRequest;
import com.vendas.api.delivery_api.controllers.response.AddressResponse;
import com.vendas.api.delivery_api.controllers.response.UserResponse;
import com.vendas.api.delivery_api.entities.Address;
import com.vendas.api.delivery_api.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class UserMapper {

    private final AddressMapper addressMapper;


    public User toUser(UserRequest userRequest){
        User user = new User();

        user.setName(userRequest.name());
        user.setPhone(userRequest.phone());
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());

        if (userRequest.addresses() != null){

            for (AddressRequest ar : userRequest.addresses()){
                Address address = addressMapper.toAddress(ar);

                user.getAddresses().add(address);
                address.setUser(user);
            }
        }
        return user;
    }

    public UserResponse toResponse(User user){
        List<AddressResponse> addressResponse = user.getAddresses()
                .stream()
                .map(address -> addressMapper.ToResponse(address))
                .toList();


       return new UserResponse (
               user.getId(),
               user.getName(),
               user.getPhone(),
               user.getEmail()

       );

    }

    public UserResponse toUpdateResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getPhone(),
                user.getEmail()
        );
    }
}
