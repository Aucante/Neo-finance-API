package com.example.neofinanceapi.services.Impl;

import com.example.neofinanceapi.dto.FinancialResultDto;
import com.example.neofinanceapi.dto.UserDto;
import com.example.neofinanceapi.exceptions.ObjectsValidator;
import com.example.neofinanceapi.models.FinancialResult;
import com.example.neofinanceapi.models.User;
import com.example.neofinanceapi.repositories.FinancialResultRepository;
import com.example.neofinanceapi.services.FinancialResultService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FinancialResultServiceImpl implements FinancialResultService {

    private final FinancialResultRepository financialResultRepository;

    private final ObjectsValidator<FinancialResultDto> validator;

    @Override
    public Integer save(FinancialResultDto dto) {
        validator.validate(dto);
        FinancialResult financialResult = FinancialResultDto.toFinancialResultEntity(dto);

        return financialResultRepository.save(financialResult).getId();
    }

    @Override
    public List<FinancialResultDto> findAll() {
        return financialResultRepository.findAll()
                .stream()
                .map(FinancialResultDto::fromFinancialResultEntity)
                .collect(Collectors.toList());
    }

    @Override
    public FinancialResultDto findById(Integer id) {
        return financialResultRepository.findById(id)
                .map(FinancialResultDto::fromFinancialResultEntity)
                .orElseThrow(() -> new EntityNotFoundException("Financial result not found with this provided ID : ." + id));
    }

    @Override
    public void delete(Integer id) {
        financialResultRepository.deleteById(id);
    }
}
