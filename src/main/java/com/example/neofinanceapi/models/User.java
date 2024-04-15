package com.example.neofinanceapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String lastname;

    private String firstname;

    private String username;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Portfolio> portfolios;

    @OneToOne
    private Configuration configuration;

    @OneToMany(mappedBy = "user")
    private List<Income> incomes;

    @OneToMany(mappedBy = "user")
    private List<Outcome> outcomes;
}
