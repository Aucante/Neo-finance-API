package com.example.neofinanceapi.repositories;

import com.example.neofinanceapi.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Integer> { }
