package com.example.neofinanceapi.controllers;

import com.example.neofinanceapi.dto.OutcomeDto;
import com.example.neofinanceapi.services.OutcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outcomes")
@RequiredArgsConstructor
public class OutcomeController {

    private final OutcomeService outcomeService;

    @PostMapping("")
    public ResponseEntity<Integer> save(
            @RequestBody OutcomeDto outcomeDto
    ) {
        return ResponseEntity.ok(outcomeService.save(outcomeDto));
    }

    @GetMapping("")
    public ResponseEntity<List<OutcomeDto>> findAll() {
        return ResponseEntity.ok(outcomeService.findAll());
    }

    @GetMapping("/{outcome-id}")
    public ResponseEntity<OutcomeDto> findById(
            @PathVariable("outcome-id") Integer outcomeId
    ) {
        return ResponseEntity.ok(outcomeService.findById(outcomeId));
    }

    @DeleteMapping("/{outcome-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("outcome-id") Integer outcomeId
    ) {
        outcomeService.delete(outcomeId);
        return ResponseEntity.accepted().build();
    }
}
