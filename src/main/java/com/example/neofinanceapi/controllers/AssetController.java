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

    @GetMapping("/{asset_id}")
    public ResponseEntity<AssetDto> findById(
            @PathVariable Integer asset_id
    ) {
        return ResponseEntity.ok(assetService.findById(asset_id));
    }

    @DeleteMapping("/{asset_id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Integer asset_id
    ) {
        assetService.delete(asset_id);
        return ResponseEntity.accepted().build();
    }
}
