package org.calc4group.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private Integer expenseId;
    private String description;
    private Long totalAmount;

    @ManyToMany
    private Map<User, SplitRule> payers = new HashMap<>();

    @ManyToMany
//    @JoinTable(name = "expense_paid_for", joinColumns = @JoinColumn(name = "expense_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Map<User, SplitRule> participants = new HashMap<>();

}
