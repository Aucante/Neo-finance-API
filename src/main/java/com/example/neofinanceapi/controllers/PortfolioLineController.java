package com.example.neofinanceapi.controllers;

import com.example.neofinanceapi.dto.PortfolioLineDto;
import com.example.neofinanceapi.services.PortfolioLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio-lines")
@RequiredArgsConstructor
public class PortfolioLineController {

    private final PortfolioLineService portfolioLineService;

    @PostMapping("")
    public ResponseEntity<Integer> save(
            @RequestBody PortfolioLineDto portfolioLineDto
    ) {
        return ResponseEntity.ok(portfolioLineService.save(portfolioLineDto));
    }

    @GetMapping("")
    public ResponseEntity<List<PortfolioLineDto>> findAll() {
        return ResponseEntity.ok(portfolioLineService.findAll());
    }

    @GetMapping("/{portfolio-line-id}")
    public ResponseEntity<PortfolioLineDto> findById(
            @PathVariable("portfolio-line-id") Integer portfolioLineId
    ) {
        return ResponseEntity.ok(portfolioLineService.findById(portfolioLineId));
    }

    @DeleteMapping("/{portfolio-line-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("portfolio-line-id") Integer portfolioLineId
    ) {
        portfolioLineService.delete(portfolioLineId);
        return ResponseEntity.accepted().build();
    }
}
