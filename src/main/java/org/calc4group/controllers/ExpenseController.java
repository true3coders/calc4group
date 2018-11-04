package org.calc4group.controllers;

import org.calc4group.dtos.ExpenseDto;
import org.calc4group.entities.Expense;
import org.calc4group.entities.User;
import org.calc4group.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @PostMapping("/createExpense")
    public String createExpense(ExpenseDto expenseDto) {
        Expense expense = expenseService.createExpense(expenseDto);
        return "Added " + expense.toString();
    }

    @PostMapping("/getExpense")
    public ExpenseDto getExpense(Integer expenseId) {
        Optional<Expense> optional = expenseService.getExpense(expenseId);
        Expense expense = optional.get();
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setDescription(expense.getDescription());
        expenseDto.setPaidFor(expense.getPaidFor().stream().map(User::getUserId).collect(Collectors.toList()));
        expenseDto.setTotalAmount(expense.getTotalAmount());
        expenseDto.setWhoPaid(expense.getWhoPaid().getUserId());
        expenseDto.setId(expense.getExpenseId());
        return expenseDto;
    }

    @PostMapping("/updateExpense")
    public String updateExpense(ExpenseDto expenseDto) {
        Expense expense = expenseService.updateExpense(expenseDto);
        return "Added " + expense.toString();
    }

    @PostMapping("/deleteExpense")
    public String deleteExpense(ExpenseDto expenseDto) {
        expenseService.deleteExpense(expenseDto);
        return expenseDto.getId() + "deleted";
    }
}
