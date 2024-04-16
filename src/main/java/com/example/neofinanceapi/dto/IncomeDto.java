package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.Income;
import com.example.neofinanceapi.models.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    private String month;

    private Integer year;

    private BigDecimal value;

    private String type;

    private String description;

    private UserDto userDto;

    public static IncomeDto fromIncomeEntity(Income income) {
        return IncomeDto.builder()
                .id(income.getId())
                .month(income.getMonth())
                .year(income.getYear())
                .value(income.getValue())
                .type(income.getType())
                .description(income.getDescription())
                .userDto(UserDto.fromUserEntity(income.getUser()))
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
                .user(UserDto.toUserEntity(incomeDto.getUserDto()))
                .build();
    }
}
