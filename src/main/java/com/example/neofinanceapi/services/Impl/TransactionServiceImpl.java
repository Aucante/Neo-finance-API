package com.example.neofinanceapi.services.Impl;

import com.example.neofinanceapi.dto.TransactionDto;
import com.example.neofinanceapi.models.Transaction;
import com.example.neofinanceapi.repositories.TransactionRepository;
import com.example.neofinanceapi.services.TransactionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Integer save(TransactionDto dto) {
        Transaction transaction = TransactionDto.toTransactionEntity(dto);

        return transactionRepository.save(transaction).getId();
    }

    @Override
    public List<TransactionDto> findAll() {
        return transactionRepository.findAll()
                .stream()
                .map(TransactionDto::fromTransactionEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto findById(Integer id) {
        return transactionRepository.findById(id)
                .map(TransactionDto::fromTransactionEntity)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found with this provided ID : ." + id));
    }

    @Override
    public void delete(Integer id) {
        transactionRepository.deleteById(id);
    }
}
