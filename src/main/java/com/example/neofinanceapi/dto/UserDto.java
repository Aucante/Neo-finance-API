package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.User;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {

    private static final int NAME_MIN_SIZE = 2;
    private static final int NAME_MAX_SIZE = 25;
    private static final int PASSWORD_MIN_SIZE = 8;
    private static final int PASSWORD_MAX_SIZE = 20;

    private Integer id;

    @NotBlank(message = "Email can't be null.")
    @Email(message = "The field requires an email format.")
    private String email;

    @NotBlank(message = "Lastname can't be null.")
    @Size(min = NAME_MIN_SIZE, max = NAME_MAX_SIZE, message = "The lastname must be between " + NAME_MIN_SIZE + " and " + NAME_MAX_SIZE + " characters.")
    private String lastname;

    @NotBlank(message = "Firstname must be filled.")
    @Size(min = NAME_MIN_SIZE, max = NAME_MAX_SIZE, message = "The firstname must be between " + NAME_MIN_SIZE + " and " + NAME_MAX_SIZE + " characters.")
    private String firstname;

    @NotBlank(message = "Username can't be null.")
    @Size(min = NAME_MIN_SIZE, max = NAME_MAX_SIZE, message = "The username must be between " + NAME_MIN_SIZE + " and " + NAME_MAX_SIZE + " characters.")
    private String username;

    @NotBlank(message = "Password can't be null.")
    @Size(min = PASSWORD_MIN_SIZE, max = PASSWORD_MAX_SIZE, message = "The password must be between " + PASSWORD_MIN_SIZE + " and " + PASSWORD_MAX_SIZE + " characters.")
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
