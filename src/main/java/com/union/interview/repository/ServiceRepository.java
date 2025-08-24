package com.union.interview.repository;

import com.union.interview.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
    Optional<ServiceEntity> findByCode(String code);
}
