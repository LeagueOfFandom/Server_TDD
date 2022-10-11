package com.swm.lofserver_tdd.repository;

import com.swm.lofserver_tdd.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByEmail(String email);
}
