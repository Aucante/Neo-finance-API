package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.FinancialResult;
import com.example.neofinanceapi.models.Portfolio;
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

    private BigDecimal value;

    private String month;

    private Integer year;

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
