package org.example.logitrack.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderStatusChangeDto(
        @NotNull Long orderId,
        @NotBlank String previousStatus,
        @NotBlank String newStatus
) {}
