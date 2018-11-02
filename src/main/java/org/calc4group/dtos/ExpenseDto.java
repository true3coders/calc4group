package org.calc4group.dtos;


import org.calc4group.entities.User;

import java.util.List;

public class ExpenseDto {

    private String description;

    private Long totalAmount;

    private User whoPaid;

    private List<User> paidFor;

}
