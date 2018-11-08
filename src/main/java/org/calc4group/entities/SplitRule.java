package org.calc4group.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SplitRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rule_id")
    private Integer ruleId;
    private Boolean isEqually;
    private Long percent;
    private Long extraAmount;

}
