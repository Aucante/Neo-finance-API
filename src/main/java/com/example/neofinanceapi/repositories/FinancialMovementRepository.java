package com.example.neofinanceapi.repositories;

import com.example.neofinanceapi.models.FinancialMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialMovementRepository extends JpaRepository<FinancialMovement, Integer> { }
