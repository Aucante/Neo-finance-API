package com.example.neofinanceapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "\"configuration\"")
public class Configuration extends AbstractDateEntity {
    private String currency;

    private Boolean isLightMode;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}