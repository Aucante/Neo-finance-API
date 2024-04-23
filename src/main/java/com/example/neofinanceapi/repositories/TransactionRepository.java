package com.example.neofinanceapi.repositories;

import com.example.neofinanceapi.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> { }
