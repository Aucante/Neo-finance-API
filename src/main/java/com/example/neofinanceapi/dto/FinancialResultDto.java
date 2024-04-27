package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.FinancialResult;
import com.example.neofinanceapi.models.Portfolio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FinancialResultDto {

    private Integer id;

    @NotNull(message = "The value is required.")
    @Positive(message = "The value must be positive.")
    private BigDecimal value;

    @NotBlank(message = "The month is required.")
    private String month;

    @NotNull(message = "The year is required.")
    private Integer year;

    @NotNull(message = "The portfolio ID is required")
    private Integer portfolioId;

    public static FinancialResultDto fromFinancialResultEntity(FinancialResult financialResult) {
        return FinancialResultDto.builder()
                .id(financialResult.getId())
                .value(financialResult.getValue())
                .month(financialResult.getMonth())
                .year(financialResult.getYear())
                .portfolioId(financialResult.getPortfolio().getId())
                .build();
    }

    public static FinancialResult toFinancialResultEntity(FinancialResultDto financialResultDto) {
        return FinancialResult.builder()
                .id(financialResultDto.getId())
                .value(financialResultDto.getValue())
                .month(financialResultDto.getMonth())
                .year(financialResultDto.getYear())
                .portfolio(
                        Portfolio.builder()
                                .id(financialResultDto.getPortfolioId())
                                .build()
                )
                .build();
    }
}
