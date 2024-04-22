package com.example.neofinanceapi.controllers;

import com.example.neofinanceapi.dto.FinancialResultDto;
import com.example.neofinanceapi.services.FinancialResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financial-results")
@RequiredArgsConstructor
public class FinancialResultController {

    private final FinancialResultService financialResultService;

    @PostMapping("")
    public ResponseEntity<Integer> save(
            @RequestBody FinancialResultDto financialResultDto
    ) {
        return ResponseEntity.ok(financialResultService.save(financialResultDto));
    }

    @GetMapping("")
    public ResponseEntity<List<FinancialResultDto>> findAll() {
        return ResponseEntity.ok(financialResultService.findAll());
    }

    @GetMapping("/{financial-result-id}")
    public ResponseEntity<FinancialResultDto> findById(
            @PathVariable("financial-result-id") Integer financialResultId
    ) {
        return ResponseEntity.ok(financialResultService.findById(financialResultId));
    }

    @DeleteMapping("/{financial-result-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("financial-result-id") Integer financialResultId
    ) {
        financialResultService.delete(financialResultId);
        return ResponseEntity.accepted().build();
    }
}
