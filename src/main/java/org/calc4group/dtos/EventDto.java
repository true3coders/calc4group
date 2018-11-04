package org.calc4group.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EventDto {

    private Integer id;
    private String name;
    private String mainCurrency;
    private List<Integer> membersIds;
}
