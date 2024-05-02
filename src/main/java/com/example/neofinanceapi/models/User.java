package com.example.neofinanceapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "\"user\"")
public class User extends AbstractDateEntity {

    @Column(unique = true)
    private String email;

    private String lastname;

    private String firstname;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Portfolio> portfolios;

    @OneToOne
    private Configuration configuration;

    @OneToMany(mappedBy = "user")
    private List<Income> incomes;

    @OneToMany(mappedBy = "user")
    private List<Outcome> outcomes;

    @OneToOne
    private Role role;

}
