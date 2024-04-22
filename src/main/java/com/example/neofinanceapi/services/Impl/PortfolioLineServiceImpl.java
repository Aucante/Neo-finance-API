package com.example.neofinanceapi.services.Impl;

import com.example.neofinanceapi.dto.PortfolioLineDto;
import com.example.neofinanceapi.models.PortfolioLine;
import com.example.neofinanceapi.repositories.PortfolioLineRepository;
import com.example.neofinanceapi.services.PortfolioLineService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PortfolioLineServiceImpl implements PortfolioLineService {

    private final PortfolioLineRepository portfolioLineRepository;

    @Override
    public Integer save(PortfolioLineDto dto) {
        PortfolioLine portfolioLine = PortfolioLineDto.toPortfolioLineEntity(dto);

        return portfolioLineRepository.save(portfolioLine).getId();
    }

    @Override
    public List<PortfolioLineDto> findAll() {
        return portfolioLineRepository.findAll()
                .stream()
                .map(PortfolioLineDto::fromPortfolioLineEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PortfolioLineDto findById(Integer id) {
        return portfolioLineRepository.findById(id)
                .map(PortfolioLineDto::fromPortfolioLineEntity)
                .orElseThrow(() -> new EntityNotFoundException("Portfolio line not found with this provided ID : ." + id));
    }

    @Override
    public void delete(Integer id) {
        portfolioLineRepository.deleteById(id);
    }
}
