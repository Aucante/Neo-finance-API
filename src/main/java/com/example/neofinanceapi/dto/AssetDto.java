package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.Asset;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AssetDto {

    private Integer id;

    private String name;

    private String abbreviation;

    private BigDecimal value;

    public static AssetDto fromAssetEntity(Asset asset) {
        return AssetDto.builder()
                .id(asset.getId())
                .name(asset.getName())
                .abbreviation(asset.getAbbreviation())
                .value(asset.getValue())
                .build();
    }

    public static Asset toAssetEntity(AssetDto assetDto) {
        return Asset.builder()
                .id(assetDto.getId())
                .name(assetDto.getName())
                .abbreviation(assetDto.getAbbreviation())
                .value(assetDto.getValue())
                .build();
    }
}
