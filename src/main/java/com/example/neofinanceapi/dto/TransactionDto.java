package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.PortfolioLine;
import com.example.neofinanceapi.models.Transaction;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
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

    @NotNull(message = "The price is required.")
    @Positive(message = "The price must be positive.")
    private BigDecimal price;

    @NotNull(message = "The quantity is required.")
    @Positive(message = "The quantity must be positive.")
    private Long quantity;

    @NotNull(message = "The date is required.")
    @PastOrPresent(message = "The date must be in the past.")
    private LocalDateTime date;

    @NotNull(message = "The fees are required.")
    @Positive(message = "The fees must be positive.")
    private Float fees;

    @NotBlank(message = "The note is required.")
    private String note;

    @NotNull(message = "The purchased choice is required.")
    private Boolean isPurchased;

    @NotNull(message = "The portfolio line ID is required.")
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
