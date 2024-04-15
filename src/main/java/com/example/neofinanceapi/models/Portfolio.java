package com.example.neofinanceapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "\"portfolio\"")
public class Portfolio extends AbstractDateEntity {
    private String name;

    @Enumerated(EnumType.STRING)
    private PortfolioType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "portfolio")
    private List<PortfolioLine> portfolioLines;

    @OneToMany(mappedBy = "portfolio")
    private List<FinancialResult> financialResults;
}