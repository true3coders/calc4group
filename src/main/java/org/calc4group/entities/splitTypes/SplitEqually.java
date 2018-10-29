package org.calc4group.entities.splitTypes;

import org.calc4group.entities.User;

import java.util.HashMap;

public class SplitEqually extends AbstractSplitType {

    public SplitEqually() {
        splitType = SplitTypeEnum.EQUALLY;
    }

    public HashMap<User, Long> getPaidFor() {
        return null;
    }

    SplitTypeEnum getType() {
        return null;
    }

    SplitTypeEnum getValue() {
        return null;
    }
}
