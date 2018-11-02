package org.calc4group.dtos;


import lombok.Data;
import org.calc4group.entities.User;

import java.util.List;

@Data
public class ExpenseDto {

    private String description;

    private Long totalAmount;

    private String whoPaid;

    private List<String> paidFor;

}
