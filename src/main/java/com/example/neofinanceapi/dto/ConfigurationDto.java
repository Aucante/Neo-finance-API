package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.Configuration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ConfigurationDto {

    private String currency;

    private Boolean isLightMode;

    private UserDto userDto;

    public static ConfigurationDto fromConfigurationEntity(Configuration configuration) {
        return ConfigurationDto.builder()
                .currency(configuration.getCurrency())
                .isLightMode(configuration.getIsLightMode())
                .userDto(UserDto.fromUserEntity(configuration.getUser()))
                .build();
    }

    public static Configuration toConfigurationEntity(ConfigurationDto configurationDto) {
        return Configuration.builder()
                .currency(configurationDto.getCurrency())
                .isLightMode(configurationDto.getIsLightMode())
                .user(UserDto.toUserEntity(configurationDto.getUserDto()))
                .build();
    }
}
