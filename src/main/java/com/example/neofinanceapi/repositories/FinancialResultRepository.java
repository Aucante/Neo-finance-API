package com.example.neofinanceapi.repositories;

import com.example.neofinanceapi.models.FinancialResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialResultRepository extends JpaRepository<FinancialResult, Integer> { }
