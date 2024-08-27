package com.example.neofinanceapi.controllers;

import com.example.neofinanceapi.dto.PortfolioDto;
import com.example.neofinanceapi.dto.UserDto;
import com.example.neofinanceapi.services.PortfolioService;
import com.example.neofinanceapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolios")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping("")
    public ResponseEntity<Integer> save(
            @RequestBody PortfolioDto portfolioDto
    ) {
        return ResponseEntity.ok(portfolioService.save(portfolioDto));
    }

    @GetMapping("")
    public ResponseEntity<List<PortfolioDto>> findAll() {
        return ResponseEntity.ok(portfolioService.findAll());
    }

    @GetMapping("/{portoflio-id}")
    public ResponseEntity<PortfolioDto> findById(
            @PathVariable("portoflio-id") Integer portoflioId
    ) {
        return ResponseEntity.ok(portfolioService.findById(portoflioId));
    }

    @DeleteMapping("/{portfolio-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("portfolio-id") Integer portfolioId
    ) {
        portfolioService.delete(portfolioId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/user/{user-id}")
    public ResponseEntity<List<PortfolioDto>> findAllByUserId(
            @PathVariable("user-id") Integer userId
    ) {
        List<PortfolioDto> portfolios = portfolioService.findAllByUserId(userId);
        return ResponseEntity.ok(portfolios);
    }
}
