package com.example.neofinanceapi.services.Impl;

import com.example.neofinanceapi.dto.AssetDto;
import com.example.neofinanceapi.exceptions.ObjectsValidator;
import com.example.neofinanceapi.models.Asset;
import com.example.neofinanceapi.repositories.AssetRepository;
import com.example.neofinanceapi.services.AssetService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    private final ObjectsValidator<AssetDto> validator;

    @Override
    public Integer save(AssetDto dto) {
        validator.validate(dto);
        Asset asset = AssetDto.toAssetEntity(dto);

        return assetRepository.save(asset).getId();
    }

    @Override
    public List<AssetDto> findAll() {
        return assetRepository.findAll()
                .stream()
                .map(AssetDto::fromAssetEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AssetDto findById(Integer id) {
        return assetRepository.findById(id)
                .map(AssetDto::fromAssetEntity)
                .orElseThrow(() -> new EntityNotFoundException("Asset not found with this provided ID : ." + id));
    }

    @Override
    public void delete(Integer id) {
        assetRepository.deleteById(id);
    }
}
