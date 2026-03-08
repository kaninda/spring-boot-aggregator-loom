package com.example.aggregator.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "orders")
@Getter
public class Order {
    @Id
    private Long id;
    private double amounts;
    private String currency;
    @Column(name = "user_id")
    private Long userId;
}
