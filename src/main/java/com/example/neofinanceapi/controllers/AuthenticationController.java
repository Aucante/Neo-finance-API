package com.example.neofinanceapi.controllers;

import com.example.neofinanceapi.config.JwtService;
import com.example.neofinanceapi.dto.RegisterUserDto;
import com.example.neofinanceapi.services.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@Valid @RequestBody RegisterUserDto requestDto) {
        authenticationService.signup(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    @PostMapping("/signin")
//    public ResponseEntity<Void> signin(@Valid @RequestBody RegisterUserDto requestDto) {
//        authenticationService.signin(requestDto);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
}