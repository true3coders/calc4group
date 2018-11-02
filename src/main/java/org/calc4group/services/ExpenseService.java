package org.calc4group.services;

import org.calc4group.dtos.ExpenseDto;
import org.calc4group.entities.Expense;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {


    public Expense addExpense(String whoPaid, Long totalAmount, String[] paidFor, String description) {
        return null;
    }

    public Expense addExpense(ExpenseDto expenseDto) {
        return null;
    }
}
