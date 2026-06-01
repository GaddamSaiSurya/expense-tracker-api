package com.example.expenseTracker.controller;

import com.example.expenseTracker.entity.Expense;
import com.example.expenseTracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getAllExpense(){
        return expenseService.getAllExpense();
    }

    @PostMapping
    public void addExpense(@RequestBody @Valid Expense expense){
        expenseService.addExpense(expense);
    }

    @GetMapping("/{id}")
    public Expense getById(@PathVariable Long id){
        return expenseService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        expenseService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateExpense(@RequestBody @Valid Expense updatedExpense, @PathVariable Long id){
        expenseService.updateExpense(updatedExpense, id);
    }
}
