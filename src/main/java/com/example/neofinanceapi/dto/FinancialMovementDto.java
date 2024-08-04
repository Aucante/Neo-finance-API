package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.FinancialMovement;
import com.example.neofinanceapi.models.Income;
import com.example.neofinanceapi.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FinancialMovementDto {
    private Integer id;

    @NotBlank(message = "The month is required.")
    private String month;

    @NotNull(message = "The year is required.")
    private Integer year;

    @NotNull(message = "The value is required.")
    @Positive(message = "The value must be positive.")
    private BigDecimal value;

    @NotBlank(message = "The type is required.")
    private String type;

    @NotBlank(message = "The description is required.")
    private String description;

    @NotNull(message = "The user ID is required.")
    private Integer userId;

    public static FinancialMovementDto fromIncomeEntity(FinancialMovement financialMovement) {
        return FinancialMovementDto.builder()
                .id(financialMovement.getId())
                .month(financialMovement.getMonth())
                .year(financialMovement.getYear())
                .value(financialMovement.getValue())
                .type(financialMovement.getType())
                .description(financialMovement.getDescription())
                .userId(financialMovement.getUser().getId())
                .build();
    }

    public static FinancialMovement toIncomeEntity(FinancialMovementDto financialMovementDto) {
        return FinancialMovement.builder()
                .id(financialMovementDto.getId())
                .month(financialMovementDto.getMonth())
                .year(financialMovementDto.getYear())
                .value(financialMovementDto.getValue())
                .type(financialMovementDto.getType())
                .description(financialMovementDto.getDescription())
                .user(User.builder()
                        .id(financialMovementDto.getUserId())
                        .build())
                .build();
    }
}
