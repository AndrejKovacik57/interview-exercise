package com.union.interview.repository;

import com.union.interview.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<ContractEntity, Long> {

}
