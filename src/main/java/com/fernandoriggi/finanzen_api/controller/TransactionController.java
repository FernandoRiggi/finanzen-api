package com.fernandoriggi.finanzen_api.controller;

import com.fernandoriggi.finanzen_api.controller.mapper.TransactionMapper;
import com.fernandoriggi.finanzen_api.dto.transaction.TransactionRequestDTO;
import com.fernandoriggi.finanzen_api.dto.transaction.TransactionResponseDTO;
import com.fernandoriggi.finanzen_api.model.Transaction;
import com.fernandoriggi.finanzen_api.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping()
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody @Valid TransactionRequestDTO requestDTO){
        Transaction transactionToSave = TransactionMapper.toEntity(requestDTO);

        Transaction savedTransaction = transactionService.createTransaction(transactionToSave, requestDTO.categoryId());
        TransactionResponseDTO responseDTO = TransactionMapper.toResponseDTO(savedTransaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping()
    public ResponseEntity<List<TransactionResponseDTO>> findAllTransactions(){
        List<Transaction> transactions = transactionService.findAllTransactions();
        List<TransactionResponseDTO> responseDTOS = transactions.stream()
                                                    .map(TransactionMapper::toResponseDTO)
                                                    .toList();
        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> findTransactionById(@PathVariable Long id){
        Transaction transaction = transactionService.findTransactionById(id)
                .orElseThrow(() -> new NoSuchElementException("Transaction not found: " + id));
        TransactionResponseDTO responseDTO = TransactionMapper.toResponseDTO(transaction);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> updateTransaction(
            @PathVariable Long id,
             @RequestBody @Valid TransactionRequestDTO transactionRequestDTO){
        Transaction transactionDetails = TransactionMapper.toEntity(transactionRequestDTO);

        Transaction updatedTransaction = transactionService.updateTransaction(id, transactionDetails, transactionRequestDTO.categoryId());
        TransactionResponseDTO responseDTO = TransactionMapper.toResponseDTO(updatedTransaction);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id){
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
