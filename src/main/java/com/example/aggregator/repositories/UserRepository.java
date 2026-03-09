package com.aka.aggregator.repositories;

import com.aka.aggregator.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
