package com.example.neofinanceapi.repositories;

import com.example.neofinanceapi.models.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> { }
