package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.Asset;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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

    private static final int NAME_MIN_SIZE = 3;
    private static final int NAME_MAX_SIZE = 15;
    private static final int ABBREVIATION_SIZE = 3;

    private Integer id;

    @NotBlank(message = "The asset name must be filled.")
    @Size(min = NAME_MIN_SIZE, max = NAME_MAX_SIZE, message = "The asset name must be between " + NAME_MIN_SIZE + " and " + NAME_MAX_SIZE + " characters.")
    private String name;

    @NotBlank(message = "Asset abbreviation must be filled.")
    @Size(min = ABBREVIATION_SIZE, max = ABBREVIATION_SIZE, message = "The asset abbreviation must have exactly " + ABBREVIATION_SIZE + " characters.")
    private String abbreviation;

    @Positive(message = "The value must be positive.")
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
