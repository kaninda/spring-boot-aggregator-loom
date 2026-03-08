package com.example.aggregator.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "users")
@Getter
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
