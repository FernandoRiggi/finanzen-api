package com.fernandoriggi.finanzen_api.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequestDTO(
        @NotBlank(message = "Name cannot be blank")
        @Size(max = 100, message = "Name must not exceed 100 characters")
        String name,
        String description
) {
}
