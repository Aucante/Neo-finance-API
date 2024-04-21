package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {
    private Integer id;

    private String email;

    private String lastname;

    private String firstname;

    private String username;

    private String password;

    public static UserDto fromUserEntity(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    public static User toUserEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .lastname(userDto.getLastname())
                .firstname(userDto.getFirstname())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();
    }
}
