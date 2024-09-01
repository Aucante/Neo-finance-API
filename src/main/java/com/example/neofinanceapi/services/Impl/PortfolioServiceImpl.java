package com.example.neofinanceapi.services.Impl;

import com.example.neofinanceapi.dto.PortfolioDto;
import com.example.neofinanceapi.exceptions.ObjectsValidator;
import com.example.neofinanceapi.models.Portfolio;
import com.example.neofinanceapi.repositories.PortfolioRepository;
import com.example.neofinanceapi.services.PortfolioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;

    private final ObjectsValidator<PortfolioDto> validator;

    @Override
    public Integer save(PortfolioDto dto) {
        validator.validate(dto);
        Portfolio portfolio = PortfolioDto.toPortfolioEntity(dto);

        return portfolioRepository.save(portfolio).getId();
    }

    @Override
    public List<PortfolioDto> findAll() {
        return portfolioRepository.findAll()
                .stream()
                .map(PortfolioDto::fromPortfolioEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PortfolioDto findById(Integer id) {
        return portfolioRepository.findById(id)
                .map(PortfolioDto::fromPortfolioEntity)
                .orElseThrow(() -> new EntityNotFoundException("Portoflio not found with this provided ID : ." + id));
    }

    @Override
    public void delete(Integer id) {
        portfolioRepository.deleteById(id);
    }

    public List<PortfolioDto> findAllByUserId(Integer userId) {
        List<Portfolio> portfolios = portfolioRepository.findAllByUserId(userId);
        return portfolios.stream()
                .map(PortfolioDto::fromPortfolioEntity)
                .collect(Collectors.toList());
    }
}
