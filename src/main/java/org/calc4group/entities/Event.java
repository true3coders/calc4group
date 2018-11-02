package org.calc4group.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private Integer id;

    private String name;

    private String mainCurrency;

    @ManyToMany
    private List<User> members;

}
