package com.union.interview.dto.response;

import com.union.interview.domain.Status;

import java.math.BigDecimal;

public record ContractResponse(
        Long id,
        String providerName,
        String providerIco,
        String serviceName,
        String serviceCode,
        Integer quantity,
        BigDecimal totalPrice,
        Status status
) {}
