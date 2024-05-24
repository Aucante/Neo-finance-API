package com.example.neofinanceapi.dto.auth;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {

    private String email;

    private String message;

}
