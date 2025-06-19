package com.fernandoriggi.finanzen_api.service;

import com.fernandoriggi.finanzen_api.model.Category;
import com.fernandoriggi.finanzen_api.model.Transaction;
import com.fernandoriggi.finanzen_api.repository.CategoryRepository;
import com.fernandoriggi.finanzen_api.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Transaction createTransaction(Transaction transaction, Long categoryId){
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NoSuchElementException("Category not found: " + categoryId));

        transaction.setCategory(category);

        return transactionRepository.save(transaction);
    }

    @Transactional(readOnly = true)
    public List<Transaction> findAllTransactions(){
        List<Transaction> transactions = transactionRepository.findAll();

        transactions.forEach(transaction -> {
            if(transaction.getCategory()!=null){
                transaction.getCategory().getName();
            }
        });
        return transactions;
    }

    @Transactional(readOnly = true)
    public Optional<Transaction> findTransactionById(Long id){
        Optional<Transaction> transactionOptional =  transactionRepository.findById(id);
        transactionOptional.ifPresent(transaction -> {
            if(transaction.getCategory()!=null){
                    transaction.getCategory().getName();
            }
        });
        return transactionOptional;
    }

    @Transactional
    public Transaction updateTransaction(Long id, Transaction transactionDetails, Long categoryId){
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found: " + id));

        existingTransaction .setTransactionDate(transactionDetails.getTransactionDate());
        existingTransaction.setTransactionType(transactionDetails.getTransactionType());
        existingTransaction.setAmount(transactionDetails.getAmount());
        existingTransaction.setDescription(transactionDetails.getDescription());

        if(categoryId!=null && (existingTransaction.getCategory()==null || !categoryId.equals(existingTransaction.getCategory().getId()))){
            Category newCategory = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new NoSuchElementException("New Category not found: " + categoryId));
            existingTransaction.setCategory(newCategory);
        }else if(existingTransaction.getCategory()!=null){
            existingTransaction.getCategory().getName();
        }

        return transactionRepository.save(existingTransaction);
    }

    @Transactional
    public void deleteTransaction(Long id){
        if(!transactionRepository.existsById(id)) throw new NoSuchElementException("Entity not found: " + id);

        transactionRepository.deleteById(id);
    }
}
