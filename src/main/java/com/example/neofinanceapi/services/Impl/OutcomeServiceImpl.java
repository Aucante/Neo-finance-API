package com.example.neofinanceapi.services.Impl;

import com.example.neofinanceapi.dto.OutcomeDto;
import com.example.neofinanceapi.models.Outcome;
import com.example.neofinanceapi.repositories.OutcomeRepository;
import com.example.neofinanceapi.services.OutcomeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OutcomeServiceImpl implements OutcomeService {

    private final OutcomeRepository outcomeRepository;

    @Override
    public Integer save(OutcomeDto dto) {
        Outcome outcome = OutcomeDto.toOutcomeEntity(dto);

        return outcomeRepository.save(outcome).getId();
    }

    @Override
    public List<OutcomeDto> findAll() {
        return outcomeRepository.findAll()
                .stream()
                .map(OutcomeDto::fromOutcomeEntity)
                .collect(Collectors.toList());
    }

    @Override
    public OutcomeDto findById(Integer id) {
        return outcomeRepository.findById(id)
                .map(OutcomeDto::fromOutcomeEntity)
                .orElseThrow(() -> new EntityNotFoundException("Outcome not found with this provided ID : ." + id));
    }

    @Override
    public void delete(Integer id) {
        outcomeRepository.deleteById(id);
    }
}
