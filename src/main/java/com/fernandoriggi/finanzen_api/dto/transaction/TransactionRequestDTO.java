package com.fernandoriggi.finanzen_api.dto.transaction;

import com.fernandoriggi.finanzen_api.enums.TransactionType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionRequestDTO(
        @NotBlank(message = "Description cannot be blank")
        @Size(max = 255, message = "Description must not exceed 255 characters")
        String description,

        @NotNull(message = "Amount cannot be null")
        @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
        BigDecimal amount,

        @NotNull(message = "Transaction cannot be null")
        LocalDateTime transactionDate,

        @NotNull(message = "Transacation type cannot be null")
        TransactionType transactionType,

        @NotNull(message = "Category ID cannot be null")
        Long categoryId
)    {
}
