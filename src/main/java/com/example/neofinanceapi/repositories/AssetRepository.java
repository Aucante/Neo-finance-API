package com.example.neofinanceapi.repositories;

import com.example.neofinanceapi.models.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Integer> { }
