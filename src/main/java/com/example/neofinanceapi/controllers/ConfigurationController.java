package com.example.neofinanceapi.controllers;

import com.example.neofinanceapi.dto.ConfigurationDto;
import com.example.neofinanceapi.services.ConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configurations")
@RequiredArgsConstructor
public class ConfigurationController {

    private final ConfigurationService configurationService;

    @PostMapping("")
    public ResponseEntity<Integer> save(
            @RequestBody ConfigurationDto configurationDto
    ) {
        return ResponseEntity.ok(configurationService.save(configurationDto));
    }

    @GetMapping("")
    public ResponseEntity<List<ConfigurationDto>> findAll() {
        return ResponseEntity.ok(configurationService.findAll());
    }

    @GetMapping("/{configuration-id}")
    public ResponseEntity<ConfigurationDto> findById(
            @PathVariable("configuration-id") Integer configurationId
    ) {
        return ResponseEntity.ok(configurationService.findById(configurationId));
    }

    @DeleteMapping("/{configuration-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("configuration-id") Integer configurationId
    ) {
        configurationService.delete(configurationId);
        return ResponseEntity.accepted().build();
    }
}
