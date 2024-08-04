package com.example.neofinanceapi.services.Impl;

import com.example.neofinanceapi.dto.FinancialMovementDto;
import com.example.neofinanceapi.exceptions.ObjectsValidator;
import com.example.neofinanceapi.models.FinancialMovement;
import com.example.neofinanceapi.repositories.FinancialMovementRepository;
import com.example.neofinanceapi.services.FinancialMovementService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FinancialMovementServiceImpl implements FinancialMovementService {

    private final FinancialMovementRepository financialMovementRepository;

    private final ObjectsValidator<FinancialMovementDto> validator;

    @Override
    public Integer save(FinancialMovementDto dto) {
        validator.validate(dto);
        FinancialMovement financialMovement = FinancialMovementDto.toIncomeEntity(dto);

        return financialMovementRepository.save(financialMovement).getId();
    }

    @Override
    public List<FinancialMovementDto> findAll() {
        return financialMovementRepository.findAll()
                .stream()
                .map(FinancialMovementDto::fromIncomeEntity)
                .collect(Collectors.toList());
    }

    @Override
    public FinancialMovementDto findById(Integer id) {
        return financialMovementRepository.findById(id)
                .map(FinancialMovementDto::fromIncomeEntity)
                .orElseThrow(() -> new EntityNotFoundException("Income not found with this provided ID : ." + id));
    }

    @Override
    public void delete(Integer id) {
        financialMovementRepository.deleteById(id);
    }
}