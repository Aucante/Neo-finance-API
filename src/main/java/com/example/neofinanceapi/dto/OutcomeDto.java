package com.example.neofinanceapi.dto;

import com.example.neofinanceapi.models.Outcome;
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

    private String month;

    private Integer year;

    private BigDecimal value;

    private String type;

    private String description;

    private UserDto userDto;

    public static OutcomeDto fromOutcomeEntity(Outcome outcome) {
        return OutcomeDto.builder()
                .id(outcome.getId())
                .month(outcome.getMonth())
                .year(outcome.getYear())
                .value(outcome.getValue())
                .type(outcome.getType())
                .description(outcome.getDescription())
                .userDto(UserDto.fromUserEntity(outcome.getUser()))
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
                .user(UserDto.toUserEntity(outcomeDto.getUserDto()))
                .build();
    }
}
