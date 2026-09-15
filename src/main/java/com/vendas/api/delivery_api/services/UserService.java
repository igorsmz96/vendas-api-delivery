package com.vendas.api.delivery_api.services;

import com.vendas.api.delivery_api.config.Role;
import com.vendas.api.delivery_api.controllers.requestCreate.UserRequest;
import com.vendas.api.delivery_api.controllers.response.UserResponse;
import com.vendas.api.delivery_api.entities.User;
import com.vendas.api.delivery_api.exception.DuplicateDataException;
import com.vendas.api.delivery_api.exception.UserNotFoundException;
import com.vendas.api.delivery_api.mapper.UserMapper;
import com.vendas.api.delivery_api.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;



    public UserResponse createUser(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.email())) {
            throw new DuplicateDataException("Email já cadastrado");
        }
        User user = userMapper.toUser(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.password()));
        user.setRole(Role.USER);
        userRepository.save(user);

        return userMapper.toResponse(user);
    }

    public UserResponse findMyUser (User userAuth){
        User user = userRepository.findById(userAuth.getId())
                .orElseThrow(UserNotFoundException::new);

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

    public UserResponse updateMyUser (User userAuth, UserRequest userRequest){
        User user = userRepository.findById(userAuth.getId())
                .orElseThrow(UserNotFoundException::new);

        Optional.ofNullable(userRequest.name()).ifPresent(user::setName);
        Optional.ofNullable(userRequest.phone()).ifPresent(user::setPhone);
        Optional.ofNullable(userRequest.email()).ifPresent(user::setEmail);
        Optional.ofNullable(userRequest.password()).ifPresent(password -> user.setPassword(passwordEncoder.encode(password)));
        userRepository.save(user);
        return userMapper.toResponse(user);
    }

    public void deleteMyUser (User userAuth){
        User user = userRepository.findById(userAuth.getId())
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }

    public void deleteUserById (Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);

    }

    public UserResponse updatePartialUserById(Long id, UserRequest userRequest){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        Optional.ofNullable(userRequest.name()).ifPresent(user::setName);
        Optional.ofNullable(userRequest.phone()).ifPresent(user::setPhone);
        Optional.ofNullable(userRequest.email()).ifPresent(user::setEmail);
        Optional.ofNullable(userRequest.password()).ifPresent(password -> user.setPassword(passwordEncoder.encode(password)));

       userRepository.save(user);
       return userMapper.toResponse(user);
    }

}
