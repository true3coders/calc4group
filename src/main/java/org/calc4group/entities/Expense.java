package org.calc4group.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Expense {

    @Id
    private Integer id;
    private String content;
    //TODO: add expense-related stuff
}
