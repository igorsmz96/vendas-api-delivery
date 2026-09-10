package com.vendas.api.delivery_api.controllers;

import com.vendas.api.delivery_api.config.TokenConfig;
import com.vendas.api.delivery_api.controllers.request.LoginRequest;
import com.vendas.api.delivery_api.controllers.response.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {



    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {

        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        Authentication auth = authenticationManager.authenticate(userAndPass);
        System.out.println(auth.getAuthorities());

        String token = tokenConfig.generateToken(auth);

        return ResponseEntity.ok(new LoginResponse(token));

    }

}
