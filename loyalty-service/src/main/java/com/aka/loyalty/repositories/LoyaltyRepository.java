package com.aka.loyalty.repositories;

import com.aka.loyalty.models.Loyalty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoyaltyRepository extends JpaRepository<Loyalty, Long> {

    Loyalty findByUserId(Long userId);

}
