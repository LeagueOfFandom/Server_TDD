package com.swm.lofserver_tdd.repository;

import com.swm.lofserver_tdd.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
