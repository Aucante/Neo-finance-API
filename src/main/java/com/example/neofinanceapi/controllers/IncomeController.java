package com.example.neofinanceapi.controllers;

import com.example.neofinanceapi.dto.IncomeDto;
import com.example.neofinanceapi.dto.UserDto;
import com.example.neofinanceapi.services.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incomes")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

    @PostMapping("")
    public ResponseEntity<Integer> save(
            @RequestBody IncomeDto incomeDto
    ) {
        return ResponseEntity.ok(incomeService.save(incomeDto));
    }

    @GetMapping("")
    public ResponseEntity<List<IncomeDto>> findAll() {
        return ResponseEntity.ok(incomeService.findAll());
    }

    @GetMapping("/{income-id}")
    public ResponseEntity<IncomeDto> findById(
            @PathVariable("income-id") Integer incomeId
    ) {
        return ResponseEntity.ok(incomeService.findById(incomeId));
    }

    @DeleteMapping("/{income-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("income-id") Integer incomeId
    ) {
        incomeService.delete(incomeId);
        return ResponseEntity.accepted().build();
    }
}
