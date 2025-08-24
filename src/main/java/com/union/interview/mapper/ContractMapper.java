package com.union.interview.mapper;

import com.union.interview.dto.response.ContractResponse;
import com.union.interview.entity.ContractEntity;
import org.springframework.stereotype.Component;

@Component
public class ContractMapper {
    public ContractResponse toDto(ContractEntity c) {
        return new ContractResponse(
            c.getId(),
            c.getProvider().getName(),
            c.getProvider().getIco(),
            c.getService().getName(),
            c.getService().getCode(),
            c.getQuantity(),
            c.getTotalPrice(),
            c.getStatus()
        );
    }
}
