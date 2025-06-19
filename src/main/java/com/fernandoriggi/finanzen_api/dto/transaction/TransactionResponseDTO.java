package com.fernandoriggi.finanzen_api.dto.transaction;

import com.fernandoriggi.finanzen_api.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponseDTO(
        Long id,
        String description,
        BigDecimal amount,
        LocalDateTime transactionDate,
        TransactionType transactionType,
        Long categoryId,
        String categoryName
) {
}
