package com.fernandoriggi.finanzen_api.controller.mapper;

import com.fernandoriggi.finanzen_api.dto.transaction.TransactionRequestDTO;
import com.fernandoriggi.finanzen_api.dto.transaction.TransactionResponseDTO;
import com.fernandoriggi.finanzen_api.model.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionMapper {
    public static Transaction toEntity(TransactionRequestDTO dto){
        if(dto==null) return null;

        Transaction transaction = new Transaction();
        transaction.setDescription(dto.description());
        transaction.setAmount(dto.amount());
        transaction.setTransactionType(dto.transactionType());
        transaction.setTransactionDate(dto.transactionDate());
        return transaction;
    }

    public static TransactionResponseDTO toResponseDTO(Transaction transaction){
        if(transaction==null) return null;

        Long categoryId = null;
        String categoryName = null;
        if(transaction.getCategory()!=null){
            categoryId = transaction.getCategory().getId();
            categoryName = transaction.getCategory().getName();
        }
        return new TransactionResponseDTO(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getTransactionDate(),
                transaction.getTransactionType(),
                categoryId,
                categoryName
        );
    }

    public static List<TransactionResponseDTO> toResponseDTOList(List<Transaction> transactions){
        if(transactions==null) return null;

        return transactions.stream()
                .map(TransactionMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
