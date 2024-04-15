package com.example.neofinanceapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "\"transaction\"")
public class Transaction extends AbstractDateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal price;

    private Long quantity;

    private LocalDateTime date;

    private Float fees;

    private String note;

    private Boolean isPurchased;

    @ManyToOne
    @JoinColumn(name = "portfolio_line_id")
    private PortfolioLine portfolioLine;
}