package com.example.neofinanceapi.repositories;

import com.example.neofinanceapi.models.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer>
{
    List<Portfolio> findByUserId(Integer userId);
}
