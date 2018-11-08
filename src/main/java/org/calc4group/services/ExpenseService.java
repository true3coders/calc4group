package org.calc4group.services;

import org.calc4group.dtos.ExpenseDto;
import org.calc4group.dtos.SplitRuleDto;
import org.calc4group.dtos.UserDto;
import org.calc4group.entities.Expense;
import org.calc4group.entities.SplitRule;
import org.calc4group.entities.User;
import org.calc4group.repositories.ExpenseRepository;
import org.calc4group.repositories.SplitRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    UserService userService;
    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    SplitRuleRepository ruleRepository;

    public Expense createExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setDescription(expenseDto.getDescription());
        expense.setTotalAmount(expenseDto.getTotalAmount());
        mapDtoToEntity(expense.getPayers(), expenseDto.getPayers());
        mapDtoToEntity(expense.getParticipants(), expenseDto.getParticipants());
        return expenseRepository.save(expense);
    }

    private void mapDtoToEntity(Map<User, SplitRule> mapEntity, Map<Integer, SplitRuleDto> mapDto) {
        for (Map.Entry<Integer, SplitRuleDto> entry : mapDto.entrySet()) {
            // TODO: 08.11.2018 soooooo.... many calls of DB?
            User user = userService.getUserById(entry.getKey());
            SplitRuleDto ruleDto = entry.getValue();
            SplitRule rule = new SplitRule();
            rule.setRuleId(ruleDto.getRuleId());
            rule.setIsEqually(ruleDto.getIsEqually());
            rule.setPercent(ruleDto.getPercent());
            rule.setExtraAmount(ruleDto.getExtraAmount());
            mapEntity.put(user, rule);
        }
    }

    public Optional<Expense> getExpense(Integer expenseId) {
        return expenseRepository.findById(expenseId);
    }

    public Expense updateExpense(ExpenseDto expenseDto) {
        Optional<Expense> optional = expenseRepository.findById(expenseDto.getExpenseId());
        if (optional.isPresent()) {
            Expense expense = optional.get();
            expense.setDescription(expenseDto.getDescription());
            expense.setTotalAmount(expenseDto.getTotalAmount());
            // TODO: 08.11.2018 will update work
            mapDtoToEntity(expense.getPayers(), expenseDto.getPayers());
            mapDtoToEntity(expense.getParticipants(), expenseDto.getParticipants());
        }
        return null;
    }

    public void deleteExpense(ExpenseDto expenseDto) {
        expenseRepository.deleteById(expenseDto.getExpenseId());
    }
}
