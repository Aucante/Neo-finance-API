package com.example.neofinanceapi.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RegisterUserDto {
    private String email;

    private String password;

    private String lastName;
}
