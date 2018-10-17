package org.calc4group.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Group {

    @Id
    private Integer id;
    private String name;
    private String mainCurrency;
    // TODO: add other stuff like included users, currencies and so on
}
