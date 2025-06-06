package com.fernandoriggi.finanzen_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(length = 255)
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Transaction> transactions = new HashSet<>();

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
        transaction.setCategory(this);
    }

    public void removeTransaction(Transaction transaction){
        this.transactions.remove(transaction);
        transaction.setCategory(null);
    }
}
