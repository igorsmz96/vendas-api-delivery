package com.vendas.api.delivery_api.controllers;

import com.vendas.api.delivery_api.entities.User;

import com.vendas.api.delivery_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser (@RequestBody User user){
        return userService.createUser(user);


    }
}
