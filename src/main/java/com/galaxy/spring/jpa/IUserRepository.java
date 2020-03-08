package com.galaxy.spring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.galaxy.spring.entities.UserEntity;

/**
 * JPA Repository for UserEntity.
 */
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

}
