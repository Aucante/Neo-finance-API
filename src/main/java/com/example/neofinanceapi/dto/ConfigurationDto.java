package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.Configuration;
import com.example.neofinanceapi.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ConfigurationDto {

    private Integer id;

    private String currency;

    private Boolean isLightMode;

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
