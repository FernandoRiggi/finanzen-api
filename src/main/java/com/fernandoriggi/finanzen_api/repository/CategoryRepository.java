package com.fernandoriggi.finanzen_api.repository;

import com.fernandoriggi.finanzen_api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
