package com.example.neofinanceapi.services.Impl;

import com.example.neofinanceapi.dto.IncomeDto;
import com.example.neofinanceapi.models.Income;
import com.example.neofinanceapi.repositories.IncomeRepository;
import com.example.neofinanceapi.services.IncomeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository incomeRepository;

    @Override
    public Integer save(IncomeDto dto) {
        Income income = IncomeDto.toIncomeEntity(dto);

        return incomeRepository.save(income).getId();
    }

    @Override
    public List<IncomeDto> findAll() {
        return incomeRepository.findAll()
                .stream()
                .map(IncomeDto::fromIncomeEntity)
                .collect(Collectors.toList());
    }

    @Override
    public IncomeDto findById(Integer id) {
        return incomeRepository.findById(id)
                .map(IncomeDto::fromIncomeEntity)
                .orElseThrow(() -> new EntityNotFoundException("Income not found with this provided ID : ." + id));
    }

    @Override
    public void delete(Integer id) {
        incomeRepository.deleteById(id);
    }
}
