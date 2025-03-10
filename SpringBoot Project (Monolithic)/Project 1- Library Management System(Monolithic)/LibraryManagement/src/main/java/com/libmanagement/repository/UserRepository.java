package com.libmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.libmanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}