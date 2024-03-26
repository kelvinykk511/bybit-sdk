package org.kelvinykk511.bybitsdk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LeverageEnum {

    NON_LEVERAGE(0),
    LEVERAGE(1);

    private final int value;

}
