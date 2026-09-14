package com.vendas.api.delivery_api.controllers;

import com.vendas.api.delivery_api.controllers.request.UserRequest;
import com.vendas.api.delivery_api.controllers.response.UserResponse;

import com.vendas.api.delivery_api.entities.User;
import com.vendas.api.delivery_api.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")


public class UserController {

    private final UserService userService;

    // Publico todos podem acessar
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    // Todos os users,** ADMIN **
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        List<UserResponse> users = userService.findAllUsers();

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    // Pegar user por ID, ** ADMIN **
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        UserResponse userResponse = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    // **ADMIN** setado no security config
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> upadatePartialUserById(@PathVariable Long id, @Valid @RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.updatePartialUserById(id, userRequest);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    // **ADMIN**
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> findMyUser(@AuthenticationPrincipal User userAuth) {
        UserResponse userResponse = userService.findMyUser(userAuth);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    // atualizar meu perfil
    @PatchMapping
    public ResponseEntity<UserResponse> updateMyUser(@AuthenticationPrincipal User userAuth, @Valid @RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.updateMyUser(userAuth, userRequest);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    // delet my user
    @DeleteMapping
    public ResponseEntity<Void> deleteMyUser(@AuthenticationPrincipal User userAuth) {
        userService.deleteMyUser(userAuth);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
