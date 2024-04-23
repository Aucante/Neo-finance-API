package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.PortfolioLine;
import com.example.neofinanceapi.models.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TransactionDto {

    private Integer id;

    private BigDecimal price;

    private Long quantity;

    private LocalDateTime date;

    private Float fees;

    private String note;

    private Boolean isPurchased;

    private Integer portfolioLineId;

    public static TransactionDto fromTransactionEntity(Transaction transaction) {
        return TransactionDto.builder()
                .id(transaction.getId())
                .price(transaction.getPrice())
                .quantity(transaction.getQuantity())
                .date(transaction.getDate())
                .fees(transaction.getFees())
                .note(transaction.getNote())
                .isPurchased(transaction.getIsPurchased())
                .portfolioLineId(transaction.getId())
                .build();
    }

    public static Transaction toTransactionEntity(TransactionDto transactionDto) {
        return Transaction.builder()
                .id(transactionDto.getId())
                .price(transactionDto.getPrice())
                .quantity(transactionDto.getQuantity())
                .date(transactionDto.getDate())
                .fees(transactionDto.getFees())
                .note(transactionDto.getNote())
                .isPurchased(transactionDto.getIsPurchased())
                .portfolioLine(PortfolioLine.builder()
                        .id(transactionDto.getPortfolioLineId())
                        .build())
                .build();
    }
}
