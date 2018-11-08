package org.calc4group.dtos;


import lombok.Data;

import java.util.HashMap;

@Data
public class ExpenseDto {

    private Integer expenseId;
    private String description;
    private Long totalAmount;
    private HashMap<Integer, SplitRuleDto> payers;
    private HashMap<Integer, SplitRuleDto> participants;

}
