package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.Asset;
import com.example.neofinanceapi.models.Portfolio;
import com.example.neofinanceapi.models.PortfolioLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PortfolioLineDto {

    private Long quantity;

    private Integer assetId;

    private Integer portfolioId;

    public static PortfolioLineDto fromPortfolioLineEntity(PortfolioLine portfolioLine) {
        return PortfolioLineDto.builder()
                .quantity(portfolioLine.getQuantity())
                .assetId(portfolioLine.getAsset().getId())
                .portfolioId(portfolioLine.getPortfolio().getId())
                .build();
    }

    public static PortfolioLine toPortfolioLineEntity(PortfolioLineDto portfolioLineDto) {
        return PortfolioLine.builder()
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
