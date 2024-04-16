package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.Portfolio;
import com.example.neofinanceapi.models.PortfolioType;
import com.example.neofinanceapi.models.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PortfolioDto {

    private Integer id;

    private String name;

    private PortfolioType type;

    private UserDto userDto;

    public static PortfolioDto fromPortfolioEntity(Portfolio portfolio) {
        return PortfolioDto.builder()
                .id(portfolio.getId())
                .name(portfolio.getName())
                .type(portfolio.getType())
                .userDto(UserDto.fromUserEntity(portfolio.getUser()))
                .build();
    }

    public static Portfolio toPortfolioEntity(PortfolioDto portfolioDto) {
        return Portfolio.builder()
                .id(portfolioDto.getId())
                .name(portfolioDto.getName())
                .type(portfolioDto.getType())
                .user(UserDto.toUserEntity(portfolioDto.getUserDto()))
                .build();
    }
}
