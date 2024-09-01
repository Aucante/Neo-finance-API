package com.example.neofinanceapi.dto.user;

import com.example.neofinanceapi.dto.UserDto;
import com.example.neofinanceapi.dto.portofolio.PortfolioDetailsDto;
import com.example.neofinanceapi.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserPortfolioDetailsDto {
    private UserDto user;
    private List<PortfolioDetailsDto> portfoliosDetails;
}
