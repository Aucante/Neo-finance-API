package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.Portfolio;
import com.example.neofinanceapi.models.PortfolioType;
import com.example.neofinanceapi.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PortfolioDto {

    private String name;

    private PortfolioType type;

    private Integer userId;

    public static PortfolioDto fromPortfolioEntity(Portfolio portfolio) {
        return PortfolioDto.builder()
                .name(portfolio.getName())
                .type(portfolio.getType())
                .userId(portfolio.getUser().getId())
                .build();
    }

    public static Portfolio toPortfolioEntity(PortfolioDto portfolioDto) {
        return Portfolio.builder()
                .name(portfolioDto.getName())
                .type(portfolioDto.getType())
                .user(User.builder()
                        .id(portfolioDto.getUserId())
                        .build()
                )
                .build();
    }
}
