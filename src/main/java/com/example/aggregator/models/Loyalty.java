package com.aka.aggregator.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "loyalties")
@Getter
public class Loyalty {
    @Id
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    private String tier;
    private Integer points;
}
