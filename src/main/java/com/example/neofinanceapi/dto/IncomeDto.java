package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.Income;
import com.example.neofinanceapi.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class IncomeDto {

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

    public static IncomeDto fromIncomeEntity(Income income) {
        return IncomeDto.builder()
                .id(income.getId())
                .month(income.getMonth())
                .year(income.getYear())
                .value(income.getValue())
                .type(income.getType())
                .description(income.getDescription())
                .userId(income.getUser().getId())
                .build();
    }

    public static Income toIncomeEntity(IncomeDto incomeDto) {
        return Income.builder()
                .id(incomeDto.getId())
                .month(incomeDto.getMonth())
                .year(incomeDto.getYear())
                .value(incomeDto.getValue())
                .type(incomeDto.getType())
                .description(incomeDto.getDescription())
                .user(User.builder()
                        .id(incomeDto.getUserId())
                        .build())
                .build();
    }
}
