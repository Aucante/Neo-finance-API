package com.example.neofinanceapi.dto.portofolio;

import com.example.neofinanceapi.dto.PortfolioLineDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PortfolioDetailsDto {
    private List<PortfolioLineDto> portfolioLines;
}
