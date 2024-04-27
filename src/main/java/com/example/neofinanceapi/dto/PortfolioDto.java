package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.Portfolio;
import com.example.neofinanceapi.models.PortfolioType;
import com.example.neofinanceapi.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "The name is required.")
    private String name;

    @NotNull(message = "The type is required.")
    private PortfolioType type;

    @NotNull(message = "The user ID is required.")
    private Integer userId;

    public static PortfolioDto fromPortfolioEntity(Portfolio portfolio) {
        return PortfolioDto.builder()
                .id(portfolio.getId())
                .name(portfolio.getName())
                .type(portfolio.getType())
                .userId(portfolio.getUser().getId())
                .build();
    }

    public static Portfolio toPortfolioEntity(PortfolioDto portfolioDto) {
        return Portfolio.builder()
                .id(portfolioDto.getId())
                .name(portfolioDto.getName())
                .type(portfolioDto.getType())
                .user(User.builder()
                        .id(portfolioDto.getUserId())
                        .build()
                )
                .build();
    }
}
