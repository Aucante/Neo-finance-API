package com.example.neofinanceapi.controllers;

import com.example.neofinanceapi.config.JwtService;
import com.example.neofinanceapi.constants.Message;
import com.example.neofinanceapi.dto.auth.LoginUserDto;
import com.example.neofinanceapi.dto.auth.RegisterResponse;
import com.example.neofinanceapi.dto.auth.RegisterUserDto;
import com.example.neofinanceapi.dto.auth.LoginResponse;
import com.example.neofinanceapi.models.User;
import com.example.neofinanceapi.services.auth.AuthenticationService;
import com.example.neofinanceapi.services.token.TokenBlacklist;
import jakarta.servlet.http.HttpServletRequest;
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

    private final TokenBlacklist tokenBlacklist;

    public AuthenticationController(
            JwtService jwtService,
            AuthenticationService authenticationService,
            TokenBlacklist tokenBlacklist
    ) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.tokenBlacklist = tokenBlacklist;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> signup(@Valid @RequestBody RegisterUserDto requestDto) {
        User registeredUser = authenticationService.signup(requestDto);

        RegisterResponse registerResponse = RegisterResponse.builder().email(registeredUser.getEmail()).message(Message.REGISTERED_MESSAGE).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = LoginResponse.builder().token(jwtToken).expiresIn(jwtService.getExpirationTime()).build();

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {

        tokenBlacklist.addBlacklistTokenList(request);

        return ResponseEntity.ok("Logged out successfully");
    }
}
