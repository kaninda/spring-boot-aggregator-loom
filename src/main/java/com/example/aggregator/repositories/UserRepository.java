package com.example.aggregator.repositories;

import com.example.aggregator.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
