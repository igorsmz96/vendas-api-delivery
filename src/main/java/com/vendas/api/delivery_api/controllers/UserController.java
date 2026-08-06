package com.vendas.api.delivery_api.controllers;

import com.vendas.api.delivery_api.controllers.request.UserRequest;
import com.vendas.api.delivery_api.controllers.response.UserResponse;
import com.vendas.api.delivery_api.controllers.response.UserUpdatePatialResponse;
import com.vendas.api.delivery_api.entities.User;

import com.vendas.api.delivery_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser (@RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);

    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers(){
        List<UserResponse> users = userService.findAllUsers();

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity <UserResponse> findById(@PathVariable Long id){
        UserResponse userResponse = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <UserResponse> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUserById(@PathVariable Long id, @RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.updateUserById(id,userRequest);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserUpdatePatialResponse> upadatePartialUserById(@PathVariable Long id, @RequestBody UserRequest userRequest){
        UserUpdatePatialResponse userResponse = userService.updatePartialUserById(id,userRequest);
       return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
}
