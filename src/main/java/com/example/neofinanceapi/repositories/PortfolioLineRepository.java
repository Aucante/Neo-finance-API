package com.example.neofinanceapi.repositories;

import com.example.neofinanceapi.models.PortfolioLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioLineRepository extends JpaRepository<PortfolioLine, Integer> { }
