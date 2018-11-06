package org.calc4group.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private Integer expenseId;

    private String description;

    private Long totalAmount;

    @ManyToOne
    private User whoPaid;

    @ManyToMany
    @JoinTable(name = "expense_paid_for", joinColumns = @JoinColumn(name = "expense_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> paidFor;

}
