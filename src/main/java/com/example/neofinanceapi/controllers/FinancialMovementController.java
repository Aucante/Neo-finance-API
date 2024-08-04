package com.example.neofinanceapi.controllers;

import com.example.neofinanceapi.dto.FinancialMovementDto;
import com.example.neofinanceapi.services.FinancialMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financial-movements")
@RequiredArgsConstructor
public class FinancialMovementController {

    private final FinancialMovementService financialMovementService;

    @PostMapping("")
    public ResponseEntity<Integer> save(
            @RequestBody FinancialMovementDto financialMovementDto
    ) {
        return ResponseEntity.ok(financialMovementService.save(financialMovementDto));
    }

    @GetMapping("")
    public ResponseEntity<List<FinancialMovementDto>> findAll() {
        return ResponseEntity.ok(financialMovementService.findAll());
    }

    @GetMapping("/{financial-movement-id}")
    public ResponseEntity<FinancialMovementDto> findById(
            @PathVariable("financial-movement-id") Integer incomeId
    ) {
        return ResponseEntity.ok(financialMovementService.findById(incomeId));
    }

    @DeleteMapping("/{financial-movement-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("financial-movement-id") Integer financialMovementId
    ) {
        financialMovementService.delete(financialMovementId);
        return ResponseEntity.accepted().build();
    }
}
