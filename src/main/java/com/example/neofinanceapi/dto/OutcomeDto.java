package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.Outcome;
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
public class OutcomeDto {

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

    public static OutcomeDto fromOutcomeEntity(Outcome outcome) {
        return OutcomeDto.builder()
                .id(outcome.getId())
                .month(outcome.getMonth())
                .year(outcome.getYear())
                .value(outcome.getValue())
                .type(outcome.getType())
                .description(outcome.getDescription())
                .userId(outcome.getId())
                .build();
    }

    public static Outcome toOutcomeEntity(OutcomeDto outcomeDto) {
        return Outcome.builder()
                .id(outcomeDto.getId())
                .month(outcomeDto.getMonth())
                .year(outcomeDto.getYear())
                .value(outcomeDto.getValue())
                .type(outcomeDto.getType())
                .description(outcomeDto.getDescription())
                .user(User.builder()
                        .id(outcomeDto.getUserId())
                        .build())
                .build();
    }
}
