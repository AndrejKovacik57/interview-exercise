package com.union.interview.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;

public record CreateContractRequest(
    @Pattern(regexp="^[0-9]{8}$") String providerIco,
    @NotBlank String serviceCode,
    @NotNull @Positive(message = "quantity must be greater than 0") Integer quantity
) {}
