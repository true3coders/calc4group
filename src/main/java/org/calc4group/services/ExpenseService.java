package org.calc4group.services;

import org.calc4group.dtos.ExpenseDto;
import org.calc4group.entities.Expense;
import org.calc4group.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    UserService userService;

    @Autowired
    ExpenseRepository expenseRepository;

    public Expense createExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setDescription(expenseDto.getDescription());
        expense.setPaidFor(userService.getUsersByIds(expenseDto.getPaidFor()));
        expense.setTotalAmount(expenseDto.getTotalAmount());
        expense.setWhoPaid(userService.getUserById(expenseDto.getWhoPaid()));
        return expenseRepository.save(expense);
    }

    public Optional<Expense> getExpense(Integer expenseId) {
        return expenseRepository.findById(expenseId);
    }

    public Expense updateExpense(ExpenseDto expenseDto) {
        Optional<Expense> optional = expenseRepository.findById(expenseDto.getId());
        if (optional.isPresent()) {
            Expense expense = optional.get();
            expense.setDescription(expenseDto.getDescription());
            expense.setPaidFor(userService.getUsersByIds(expenseDto.getPaidFor()));
            expense.setTotalAmount(expenseDto.getTotalAmount());
            expense.setWhoPaid(userService.getUserById(expenseDto.getWhoPaid()));
        }
        return null;
    }

    public void deleteExpense(ExpenseDto expenseDto) {
        expenseRepository.deleteById(expenseDto.getId());
    }
}
