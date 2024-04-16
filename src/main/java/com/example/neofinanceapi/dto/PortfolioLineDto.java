package com.example.neofinanceapi.dto;

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

    private Integer id;

    private Long quantity;

    private AssetDto assetDto;

    public static PortfolioLineDto fromPortfolioLineEntity(PortfolioLine portfolioLine) {
        return PortfolioLineDto.builder()
                .id(portfolioLine.getId())
                .quantity(portfolioLine.getQuantity())
                .assetDto(AssetDto.fromAssetEntity(portfolioLine.getAsset()))
                .build();
    }

    public static PortfolioLine toPortfolioLineEntity(PortfolioLineDto portfolioLineDto) {
        return PortfolioLine.builder()
                .id(portfolioLineDto.getId())
                .quantity(portfolioLineDto.getQuantity())
                .asset(AssetDto.toAssetEntity(portfolioLineDto.getAssetDto()))
                .build();
    }
}
