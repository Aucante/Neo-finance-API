package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.FinancialResult;
import com.example.neofinanceapi.models.Portfolio;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    private PortfolioDto portfolioDto;

    public static FinancialResultDto fromFinancialResultEntity(FinancialResult financialResult) {
        return FinancialResultDto.builder()
                .id(financialResult.getId())
                .value(financialResult.getValue())
                .month(financialResult.getMonth())
                .year(financialResult.getYear())
                .portfolioDto(PortfolioDto.fromPortfolioEntity(financialResult.getPortfolio()))
                .build();
    }

    public static FinancialResult toFinancialResultEntity(FinancialResultDto financialResultDto) {
        return FinancialResult.builder()
                .id(financialResultDto.getId())
                .value(financialResultDto.getValue())
                .month(financialResultDto.getMonth())
                .year(financialResultDto.getYear())
                .portfolio(PortfolioDto.toPortfolioEntity(financialResultDto.getPortfolioDto()))
                .build();
    }
}
