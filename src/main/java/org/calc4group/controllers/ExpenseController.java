package org.calc4group.controllers;

import org.calc4group.entities.Expense;
import org.calc4group.services.UserManagementService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/expenses")
public class ExpenseController {

    // TODO: 29.10.2018 how to get services here?
    UserManagementService userService = new UserManagementService();

    @RequestMapping("/expenses/add/whoPaid={whoPaid}&totalAmount={totalAmount}&paidFor={paidFor}&description={description}")
    public String addExpense(@PathVariable("whoPaid") final String whoPaid,
                             @PathVariable("totalAmount") final Long totalAmount,
                             @PathVariable("paidFor") final String[] paidFor,
                             @PathVariable("description") final String description) {
        // TODO: 29.10.2018 addExpense to DB
        Expense expense = new Expense();
        expense.setWhoPaid(userService.getUserById(whoPaid));
        expense.setTotalAmount(totalAmount);
        expense.setPaidFor(userService.parseListOfUsers(paidFor));
        expense.setDescription(description);
        return "Added " + expense.toString();
    }
}
