package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.Asset;
import com.example.neofinanceapi.models.Portfolio;
import com.example.neofinanceapi.models.PortfolioLine;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PortfolioLineDto {

    private Integer id;

    @NotNull(message = "The quantity is required.")
    @Positive(message = "The quantity must be positive.")
    private Long quantity;

    @NotNull(message = "The asset ID is required.")
    private Integer assetId;

    @NotNull(message = "The portfolio ID is required.")
    private Integer portfolioId;

    public static PortfolioLineDto fromPortfolioLineEntity(PortfolioLine portfolioLine) {
        return PortfolioLineDto.builder()
                .id(portfolioLine.getId())
                .quantity(portfolioLine.getQuantity())
                .assetId(portfolioLine.getAsset().getId())
                .portfolioId(portfolioLine.getPortfolio().getId())
                .build();
    }

    public static PortfolioLine toPortfolioLineEntity(PortfolioLineDto portfolioLineDto) {
        return PortfolioLine.builder()
                .id(portfolioLineDto.getId())
                .quantity(portfolioLineDto.getQuantity())
                .asset(
                        Asset.builder()
                                .id(portfolioLineDto.getAssetId())
                                .build()
                )
                .portfolio(
                        Portfolio.builder()
                                .id(portfolioLineDto.getPortfolioId())
                                .build()
                )
                .build();
    }
}
