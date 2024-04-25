package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.Configuration;
import com.example.neofinanceapi.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ConfigurationDto {

    private static final int CURRENCY_MIN_SIZE = 3;
    private static final int CURRENCY_MAX_SIZE = 5;

    private Integer id;

    @NotBlank(message = "The currency is required.")
    @Size(min = CURRENCY_MIN_SIZE, max = CURRENCY_MAX_SIZE, message = "The currency must be between " + CURRENCY_MIN_SIZE + " and " + CURRENCY_MAX_SIZE + " characters.")
    private String currency;

    @NotNull(message = "The light mode choice is required.")
    private Boolean isLightMode;

    @NotNull(message = "The user is required.")
    private Integer userId;

    public static ConfigurationDto fromConfigurationEntity(Configuration configuration) {
        return ConfigurationDto.builder()
                .id(configuration.getId())
                .currency(configuration.getCurrency())
                .isLightMode(configuration.getIsLightMode())
                .userId(configuration.getUser().getId())
                .build();
    }

    public static Configuration toConfigurationEntity(ConfigurationDto configurationDto) {
        return Configuration.builder()
                .id(configurationDto.getId())
                .currency(configurationDto.getCurrency())
                .isLightMode(configurationDto.getIsLightMode())
                .user(
                    User.builder()
                        .id(configurationDto.getUserId())
                        .build())
                .build();
    }
}
