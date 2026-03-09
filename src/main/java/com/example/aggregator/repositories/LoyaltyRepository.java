package com.aka.aggregator.repositories;

import com.aka.aggregator.models.Loyalty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoyaltyRepository extends JpaRepository<Loyalty, Long> {

    Loyalty findByUserId(Long userId);

}
