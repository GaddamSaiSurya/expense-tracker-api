package com.example.expenseTracker.repository;

import com.example.expenseTracker.entity.Expense;
import com.example.expenseTracker.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByCategory(Category category);
    List<Expense> findByDateBetween(
            LocalDate startDate,
            LocalDate endDate
    );
}
