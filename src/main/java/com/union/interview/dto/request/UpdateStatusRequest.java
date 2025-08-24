package com.union.interview.dto.request;

import com.union.interview.domain.Status;
import jakarta.validation.constraints.NotNull;

public record UpdateStatusRequest(@NotNull Status status) {}
