package org.calc4group.dtos;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ExpenseDto1 {

    private Integer integer;
    private String string;
    private Long aLong;
    private Boolean aBoolean;
    private SplitRuleDto rule;
    private Map<Integer, Long> map;

}
