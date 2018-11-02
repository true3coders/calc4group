package org.calc4group.controllers;

import org.calc4group.dtos.ExpenseDto;
import org.calc4group.entities.Expense;
import org.calc4group.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/expenses")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;


    @PostMapping("/addExpense")
    public String addExpense(ExpenseDto expenseDto) {
        Expense expense = expenseService.addExpense(expenseDto);
        return "Added " + expense.toString();
    }
}
