package com.vendas.api.delivery_api.services;

import com.vendas.api.delivery_api.controllers.request.UserRequest;
import com.vendas.api.delivery_api.controllers.response.UserResponse;
import com.vendas.api.delivery_api.controllers.response.UserUpdatePatialResponse;
import com.vendas.api.delivery_api.entities.User;
import com.vendas.api.delivery_api.exception.UserNotFoundException;
import com.vendas.api.delivery_api.mapper.UserMapper;
import com.vendas.api.delivery_api.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse createUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        userRepository.save(user);


        return userMapper.toResponse(user);
    }

    public List<UserResponse> findAllUsers(){
        List <User> findAll = userRepository.findAll();

        return findAll.stream().map(userMapper::toResponse).toList();
    }

    public UserResponse findById (Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return userMapper.toResponse(user);
    }

    public void deleteUserById (Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);

    }
    public UserResponse updateUserById(Long id, UserRequest userRequest){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        user.setName(userRequest.name());
        user.setPhone(userRequest.phone());
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());

        userRepository.save(user);

        return userMapper.toResponse(user);
    }

    public UserUpdatePatialResponse updatePartialUserById(Long id, UserRequest userRequest){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        Optional.ofNullable(userRequest.name()).ifPresent(user::setName);
        Optional.ofNullable(userRequest.phone()).ifPresent(user::setPhone);
        Optional.ofNullable(userRequest.email()).ifPresent(user::setEmail);
        Optional.ofNullable(userRequest.password()).ifPresent(user::setPassword);

       userRepository.save(user);
       return userMapper.toUpdateResponse(user);
    }

}
