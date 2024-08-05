package com.example.neofinanceapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "\"financial-movement\"")
public class FinancialMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String month;

    private Integer year;

    private BigDecimal value;

    private String type;

    private String description;

    private Boolean isIncome;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}