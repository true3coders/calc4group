package org.calc4group.entities.splitTypes;

public abstract class AbstractSplitType {

    enum SplitTypeEnum {
        EQUALLY, PERCENT, AMOUNT, PERCENT_AND_AMOUNT
    }

    SplitTypeEnum splitType;


    abstract SplitTypeEnum getType();

    abstract SplitTypeEnum getValue();

}
