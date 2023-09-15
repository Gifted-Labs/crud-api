package com.systemsguy.userapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.systemsguy.userapi.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // all CRUD methods
}
