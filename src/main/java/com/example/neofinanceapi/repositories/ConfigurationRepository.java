package com.example.neofinanceapi.repositories;

import com.example.neofinanceapi.models.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> { }
