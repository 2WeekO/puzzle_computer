package com.example.puzzle_computer.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<WebUser, Long> {
    Optional<WebUser> findByUsername(String username);
}
