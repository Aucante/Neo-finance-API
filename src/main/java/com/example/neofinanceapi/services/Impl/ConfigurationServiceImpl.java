package com.example.neofinanceapi.services.Impl;

import com.example.neofinanceapi.dto.ConfigurationDto;
import com.example.neofinanceapi.exceptions.ObjectsValidator;
import com.example.neofinanceapi.models.Configuration;
import com.example.neofinanceapi.repositories.ConfigurationRepository;
import com.example.neofinanceapi.services.ConfigurationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConfigurationServiceImpl implements ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    private final ObjectsValidator<ConfigurationDto> validator;

    @Override
    public Integer save(ConfigurationDto dto) {
        validator.validate(dto);
        Configuration configuration = ConfigurationDto.toConfigurationEntity(dto);

        return configurationRepository.save(configuration).getId();
    }

    @Override
    public List<ConfigurationDto> findAll() {
        return configurationRepository.findAll()
                .stream()
                .map(ConfigurationDto::fromConfigurationEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ConfigurationDto findById(Integer id) {
        return configurationRepository.findById(id)
                .map(ConfigurationDto::fromConfigurationEntity)
                .orElseThrow(() -> new EntityNotFoundException("Configuration not found with this provided ID : ." + id));
    }

    @Override
    public void delete(Integer id) {
        configurationRepository.deleteById(id);
    }
}
