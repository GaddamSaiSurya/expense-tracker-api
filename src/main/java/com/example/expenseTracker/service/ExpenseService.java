package com.example.expenseTracker.service;

import com.example.expenseTracker.exception.ExpenseNotFoundException;
import com.example.expenseTracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import com.example.expenseTracker.entity.Expense;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }

    public void addExpense(Expense expense){
        expenseRepository.save(expense);
    }

    private Expense findExpenseOrThrow(Long id){
        return expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFoundException(id));
    }

    public Expense getById(Long id){
        return findExpenseOrThrow(id);
    }

    public void deleteById(Long id){
        Expense expense = findExpenseOrThrow(id);
        expenseRepository.delete(expense);
    }

    public void updateExpense(Expense updatedExpense, Long id){
        Expense existingExpense = findExpenseOrThrow(id);
        existingExpense.setTitle(updatedExpense.getTitle());
        existingExpense.setAmount(updatedExpense.getAmount());
        existingExpense.setCategory(updatedExpense.getCategory());
        existingExpense.setDate(updatedExpense.getDate());
        expenseRepository.save(existingExpense);

    }
}
