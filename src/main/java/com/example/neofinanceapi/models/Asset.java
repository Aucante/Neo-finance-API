package com.example.neofinanceapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "\"asset\"")
public class Asset extends AbstractDateEntity {
    private String name;

    private String abbreviation;

    private BigDecimal value;

    @OneToMany(mappedBy = "asset")
    private List<PortfolioLine> portfolioLines;
}