package org.calc4group.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "expense_id")
    private Integer id;

    private String description;

    private Long totalAmount;

//    @ManyToOne
//    private User whoPaid;
//
//    @OneToMany(mappedBy = "id")
//    private List<User> paidFor;

}
