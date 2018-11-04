package org.calc4group.dtos;


import lombok.Data;

import java.util.List;

@Data
public class ExpenseDto {

    private Integer id;
    private String description;
    private Long totalAmount;
    private Integer whoPaid;
    private List<Integer> paidFor;

}
