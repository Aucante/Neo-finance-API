package com.example.neofinanceapi.controllers;

import com.example.neofinanceapi.dto.AssetDto;
import com.example.neofinanceapi.services.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
@RequiredArgsConstructor
public class AssetController {

    private final AssetService assetService;

    @PostMapping("")
    public ResponseEntity<Integer> save(
            @RequestBody AssetDto assetDto
    ) {
        return ResponseEntity.ok(assetService.save(assetDto));
    }

    @GetMapping("")
    public ResponseEntity<List<AssetDto>> findAll() {
        return ResponseEntity.ok(assetService.findAll());
    }

    @GetMapping("/{asset-id}")
    public ResponseEntity<AssetDto> findById(
            @PathVariable("asset-id") Integer assetId
    ) {
        return ResponseEntity.ok(assetService.findById(assetId));
    }

    @DeleteMapping("/{asset-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("asset-id") Integer assetId
    ) {
        assetService.delete(assetId);
        return ResponseEntity.accepted().build();
    }
}
