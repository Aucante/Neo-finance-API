package com.example.neofinanceapi.services;

import com.example.neofinanceapi.dto.PortfolioDto;

import java.util.List;

public interface PortfolioService extends AbstractService<PortfolioDto>
{
    List<PortfolioDto> findAllByUserId(Integer userId);
}
