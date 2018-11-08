package org.calc4group.controllers;

import org.calc4group.dtos.ExpenseDto;
import org.calc4group.dtos.ExpenseDto1;
import org.calc4group.dtos.SplitRuleDto;
import org.calc4group.dtos.UserDto;
import org.calc4group.entities.Expense;
import org.calc4group.entities.SplitRule;
import org.calc4group.entities.User;
import org.calc4group.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @PostMapping("/testExpense")
    public ExpenseDto1 testExpense(ExpenseDto1 expenseDto) {
        return expenseDto;
    }

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
        expenseDto.setExpenseId(expense.getExpenseId());
        expenseDto.setDescription(expense.getDescription());
        expenseDto.setTotalAmount(expense.getTotalAmount());
        mapEntitytoDto(expenseDto.getPayers(), expense.getPayers());
        mapEntitytoDto(expenseDto.getParticipants(), expense.getParticipants());
        return expenseDto;
    }

    private void mapEntitytoDto(Map<Integer, SplitRuleDto> mapDto, Map<User, SplitRule> mapEntity) {
        for (Map.Entry<User, SplitRule> entry : mapEntity.entrySet()) {
            // TODO: 08.11.2018 soooooo.... many calls of DB?
//            UserDto userDto = userEntityToDto(entry.getKey());
            Integer userDto = entry.getKey().getUserId();
            SplitRule ruleEntity = entry.getValue();
            SplitRuleDto ruleDto = new SplitRuleDto();
            ruleDto.setRuleId(ruleEntity.getRuleId());
            ruleDto.setIsEqually(ruleEntity.getIsEqually());
            ruleDto.setPercent(ruleEntity.getPercent());
            ruleDto.setExtraAmount(ruleEntity.getExtraAmount());
            mapDto.put(userDto, ruleDto);
        }

    }

    private UserDto userEntityToDto(User user) {
//        UserDto userDto = new UserDto();
//        userDto.setUserId(user.getUserId());
//        userDto.setName(user.getName());
        return new UserDto(user.getUserId(), user.getName());
    }

    @PostMapping("/updateExpense")
    public String updateExpense(ExpenseDto expenseDto) {
        Expense expense = expenseService.updateExpense(expenseDto);
        return "Added " + expense.toString();
    }

    @PostMapping("/deleteExpense")
    public String deleteExpense(ExpenseDto expenseDto) {
        expenseService.deleteExpense(expenseDto);
        return expenseDto.getExpenseId() + "deleted";
    }
}
