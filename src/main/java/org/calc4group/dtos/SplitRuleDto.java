package org.calc4group.dtos;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public class SplitRuleDto {

    private Integer ruleId;
    private Boolean isEqually;
    private Long percent;
    private Long extraAmount;

}
