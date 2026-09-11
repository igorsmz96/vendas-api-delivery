package com.vendas.api.delivery_api.mapper;


import com.vendas.api.delivery_api.controllers.request.UserRequest;
import com.vendas.api.delivery_api.controllers.response.UserResponse;
import com.vendas.api.delivery_api.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {


    public User toUser(UserRequest userRequest){
        User user = new User();

        user.setName(userRequest.name());
        user.setPhone(userRequest.phone());
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());


        return user;
    }

    public UserResponse toResponse(User user){

       return new UserResponse (
               user.getId(),
               user.getName(),
               user.getPhone(),
               user.getEmail(),
               user.getRole()

       );

    }


}
