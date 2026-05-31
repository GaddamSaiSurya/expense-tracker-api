package com.example.expenseTracker.service;

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

    public Optional<Expense> getById(Long id){
        return expenseRepository.findById(id);
    }

    public void deleteById(Long id){
        expenseRepository.deleteById(id);
    }

    public void updateExpense(Expense updatedExpense, Long id){
        Optional<Expense> expense = expenseRepository.findById(id);
        if(expense.isPresent()){
            Expense existingExpense = expense.get();
            existingExpense.setTitle(updatedExpense.getTitle());
            existingExpense.setAmount(updatedExpense.getAmount());
            existingExpense.setCategory(updatedExpense.getCategory());
            existingExpense.setDate(updatedExpense.getDate());

            expenseRepository.save(existingExpense);
        }
    }
}
