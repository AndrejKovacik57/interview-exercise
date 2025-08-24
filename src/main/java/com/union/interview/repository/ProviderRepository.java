package com.union.interview.repository;

import com.union.interview.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProviderRepository extends JpaRepository<ProviderEntity, Long> {
    Optional<ProviderEntity> findByIco(String ico);
}
